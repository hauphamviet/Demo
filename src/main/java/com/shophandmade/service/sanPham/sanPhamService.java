package com.shophandmade.service.sanPham;

import com.shophandmade.controller.sanPham.sanPhamRequest;
import com.shophandmade.entity.sanPhamEntity;

import java.util.List;

public interface sanPhamService {

    sanPhamEntity saveSanPham(sanPhamRequest sanPhamRequest);

    List<sanPhamEntity> getAllSP();

    sanPhamEntity getSPById(Integer id);

    sanPhamEntity updateSanPham(Integer id, sanPhamRequest sanPhamRequest);

    void deleteSanPham(Integer id);

    sanPhamEntity updateTrangThai(Integer id, sanPhamRequest sanPhamRequest);

    List<sanPhamEntity> getProductsByCategory(Integer id);

    sanPhamEntity getSanPhamById(Integer id);

}
