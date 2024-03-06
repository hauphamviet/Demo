package com.shophandmade.service.danhMucSanPham;

import com.shophandmade.controller.danhMucSanPham.danhMucSanPhamRequest;
import com.shophandmade.entity.danhMucSanPhamEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface danhMucSanPhamService {

    List<danhMucSanPhamEntity> getAllDMSP();

    danhMucSanPhamEntity getDMSPById(Integer id);

    danhMucSanPhamEntity saveDMSP(danhMucSanPhamRequest danhMucSanPhamRequest);

    danhMucSanPhamEntity updateDMSP(Integer id, danhMucSanPhamRequest danhMucSanPhamRequest);

    void deleteDMSP(Integer id);

}
