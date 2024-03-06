package com.shophandmade.service.khachHang;

import com.shophandmade.controller.khachHang.khachHangRequest;
import com.shophandmade.entity.khachHangEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface khachHangService {

    ResponseEntity<String> signUp(Map<String, String> requestMap);

    ResponseEntity<Map<String, String>> login(Map<String, String> requestMap);

    ResponseEntity<Map<String, String>> checkToken();

    List<khachHangEntity> getAllKH();

    khachHangEntity getKHById(Integer id);

    khachHangEntity findByEmail(String email);

    khachHangEntity findByHoTen(String hoTen);

    khachHangEntity updateKhachHang(Integer id, khachHangRequest khachHangRequest);

    void deleteKhachHang(Integer id);

    List<khachHangEntity> layTatCaKhachHang();

    khachHangEntity layKhachHangBangId(Integer id);

    khachHangEntity findBySDT(String sdt);

}
