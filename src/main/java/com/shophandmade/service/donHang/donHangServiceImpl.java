package com.shophandmade.service.donHang;

import com.shophandmade.JWT.JwtFilter;
import com.shophandmade.common.Constants;
import com.shophandmade.controller.donHang.donHangRequest;
import com.shophandmade.entity.donHangEntity;
import com.shophandmade.enums.trangThaiEnum;
import com.shophandmade.exception.NotFoundException;
import com.shophandmade.repository.donHangRepository;
import com.shophandmade.repository.khachHangRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class donHangServiceImpl implements donHangService {

    private final donHangRepository donHangRepository;
    private final JwtFilter jwtFilter;
    private final khachHangRepository khachHangRepository;

    @Override
    public List<donHangEntity> getAllDonHang() {
        List<donHangEntity> list = new ArrayList<>();
        if (jwtFilter.isAdmin()) {
            list = donHangRepository.findAll();
        } else {
            Optional<donHangEntity> donHang = donHangRepository.findByHoTen(jwtFilter.getCurrentUser());
        }
        return list;
    }

    @Override
    public void deleteDonHang(Integer id) {
        var donHangOpt = donHangRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format(Constants.MA_DON_HANG_KHONG_TON_TAI, id)));
        donHangRepository.deleteById(id);

    }

    @Override
    public donHangEntity getDonHangById(Integer id) {
        return donHangRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format(Constants.MA_DON_HANG_KHONG_TON_TAI, id)));
    }

    @Override
    public List<donHangEntity> getDonByKhachHang(String hoTen) {
        var khachHang = khachHangRepository.findByHoTen(hoTen)
                .orElseThrow(() -> new NotFoundException(Constants.KHONG_TIM_THAY_TEN_NGUOI_DUNG));
        return donHangRepository.getDonHangByKhachHang(khachHang.getId());
    }

    @Override
    public donHangEntity updateDonHang(Integer id, donHangRequest donHangRequest) {
        if (jwtFilter.isAdmin()) {
            var donHangOpt = donHangRepository.findById(id);
            if (donHangOpt.isPresent()) {
                var donHangEntity = donHangOpt.get();
                donHangEntity.setTrangThai(donHangRequest.getTrangThai());
                return donHangRepository.save(donHangEntity);
            }
        }
        return null;
    }

}
