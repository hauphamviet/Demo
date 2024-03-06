package com.shophandmade.service.khachHang;

import com.shophandmade.JWT.CustomerUserDetailsService;
import com.shophandmade.JWT.JwtFilter;
import com.shophandmade.JWT.JwtUtil;
import com.shophandmade.common.Constants;
import com.shophandmade.controller.khachHang.khachHangRequest;
import com.shophandmade.entity.khachHangEntity;
import com.shophandmade.exception.NotFoundException;
import com.shophandmade.repository.khachHangRepository;
import com.shophandmade.utils.WebUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Log4j2
@RequiredArgsConstructor
public class khachHangServiceImpl implements khachHangService {

    private final khachHangRepository khachHangRepository;
    private final AuthenticationManager authenticationManager;
    private final CustomerUserDetailsService customerUserDetailsService;
    private final JwtUtil jwtUtil;
    private final JwtFilter jwtFilter;
    private final PasswordEncoder passwordEncoder;

    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {
        log.info("Dang ky ben trong {}", requestMap);
        try {
            if (validateSignUpMap(requestMap)) {
                var userEntity = khachHangRepository.findByEmail(requestMap.get("email"));
                if (Objects.isNull(userEntity)) {
                    khachHangRepository.save(getUserFromMap(requestMap));
                    return WebUtils.getResponseEntity("Dang ky thang cong", HttpStatus.OK);
                } else {
                    return WebUtils.getResponseEntity("Email som da ton tai!", HttpStatus.BAD_REQUEST);
                }
            } else {
                return WebUtils.getResponseEntity(Constants.DU_LIEU_KHONG_HOP_LE, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return WebUtils.getResponseEntity(Constants.DA_XAY_RA_SU_CO, HttpStatus.INTERNAL_SERVER_ERROR);
    }

//    @Override
//    public khachHangEntity saveUser(khachHangEntity khachHang, Set<khacHangRole> khachHangRoleSet) throws Exception {
//        var local = this.khachHangRepository.findByHoTen(khachHang.getHoTen());
//        if (local != null) {
//            System.out.println("User is already there!!");
//            throw new Exception("User is already present!!");
//        } else {
//            //user create
//        }
//    }

    @Override
    public ResponseEntity<Map<String, String>> login(Map<String, String> requestMap) {
        log.info("Dang nhap ben trong");
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(requestMap.get("email"), requestMap.get("matKhau"))
            );
            if (authentication.isAuthenticated()) {
                if (customerUserDetailsService.getUserDetail().getTrangThai().equalsIgnoreCase("true")) {
                    String token = jwtUtil.generateToken(customerUserDetailsService.getUserDetail().getEmail(),
                            customerUserDetailsService.getUserDetail().getRole());
                    Map<String, String> mapToken = new HashMap<>();
                    mapToken.put("token", token);
                    return new ResponseEntity<Map<String, String>>(mapToken,
                            HttpStatus.OK);

                } else {
                    Map<String, String> mapToken = new HashMap<>();
                    mapToken.put("message", "Dang cho duyet cua quan tri vien");
                    return new ResponseEntity<Map<String, String>>(mapToken,
                            HttpStatus.BAD_REQUEST);
                }
            }
        } catch (Exception ex) {
            log.error("{}", ex);
        }
        Map<String, String> mapToken = new HashMap<>();
        mapToken.put("message", "Thong tin xac thuc sai");
        return new ResponseEntity<Map<String, String>>(mapToken,
                HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Map<String, String>> checkToken() {
        Map<String, String> mapCheck = new HashMap<>();
        mapCheck.put("message", "true");
        return new ResponseEntity<>(mapCheck, HttpStatus.OK);
    }

    @Override
    public List<khachHangEntity> getAllKH() {
        if (jwtFilter.isAdmin()) {
            return khachHangRepository.findAll();
        }
        return null;
    }

    @Override
    public khachHangEntity getKHById(Integer id) {
        return khachHangRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format(Constants.MA_KHACH_HANG_KHONG_TON_TAI, id)));
    }

    @Override
    public khachHangEntity findByEmail(String email) {
        return khachHangRepository.findByEmail(email);
    }

    @Override
    public khachHangEntity findByHoTen(String hoTen) {
        return khachHangRepository.findByHoTen(hoTen)
                .orElseThrow(() -> new NotFoundException(Constants.KHONG_TIM_THAY_TEN_NGUOI_DUNG));
    }

    @Override
    public khachHangEntity updateKhachHang(Integer id, khachHangRequest khachHangRequest) {
        if (jwtFilter.isAdmin()) {
            var userEntityOpt = khachHangRepository.findById(id);
            if (userEntityOpt.isPresent()) {
                var khachangEntity = userEntityOpt.get();
                khachangEntity.setTrangThai(khachHangRequest.getTrangThai());
                return khachHangRepository.save(khachangEntity);
            }
            throw new NotFoundException(String.format(Constants.MA_KHACH_HANG_KHONG_TON_TAI, id));
        }
       return null;
    }

    @Override
    public void deleteKhachHang(Integer id) {
        var khachHangEntity = khachHangRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format(Constants.MA_KHACH_HANG_KHONG_TON_TAI, id)));
        khachHangRepository.deleteById(id);
    }

    @Override
    public List<khachHangEntity> layTatCaKhachHang() {
        return khachHangRepository.findAll();
    }

    @Override
    public khachHangEntity layKhachHangBangId(Integer id) {
        return khachHangRepository.findById(id)
                .orElseThrow(()-> new NotFoundException(String.format(Constants.MA_KHACH_HANG_KHONG_TON_TAI, id)));
    }

    @Override
    public khachHangEntity findBySDT(String sdt) {
        return khachHangRepository.findBySDT(sdt)
                .orElseThrow(() -> new NotFoundException(Constants.DA_XAY_RA_SU_CO));
    }


    private boolean validateSignUpMap(Map<String, String> requestMap) {
        if (requestMap.containsKey("matKhau") && requestMap.containsKey("hoTen")
                 && requestMap.containsKey("SDT") && requestMap.containsKey("email")
                && requestMap.containsKey("diaChi")) {
            return true;
        }
        return false;
    }

    private khachHangEntity getUserFromMap(Map<String, String> requestMap) {
        var userEntity = new khachHangEntity();
        userEntity.setTenTaiKhoan(requestMap.get("tenTaiKhoan"));
        userEntity.setMatKhau(passwordEncoder.encode(requestMap.get("matKhau")));
        userEntity.setHoTen(requestMap.get("hoTen"));
        userEntity.setSDT(requestMap.get("SDT"));
        userEntity.setEmail(requestMap.get("email"));
        userEntity.setDiaChi(requestMap.get("diaChi"));
        userEntity.setTrangThai("false");

        userEntity.setRole("user");

        return userEntity;

    }

    private Date parseDateString(String dateString) {
        if (dateString != null && !dateString.isEmpty()) {
            try {
                return new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return null; // Trả về null nếu chuỗi là null hoặc trống
        }
    }



}
