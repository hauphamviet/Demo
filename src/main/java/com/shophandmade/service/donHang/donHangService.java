package com.shophandmade.service.donHang;

import com.shophandmade.controller.donHang.donHangRequest;
import com.shophandmade.entity.donHangEntity;

import java.util.List;

public interface donHangService {

    List<donHangEntity> getAllDonHang();

    void deleteDonHang(Integer id);

    donHangEntity getDonHangById(Integer id);

    List<donHangEntity> getDonByKhachHang(String hoTen);

    donHangEntity updateDonHang(Integer id, donHangRequest donHangRequest);


}
