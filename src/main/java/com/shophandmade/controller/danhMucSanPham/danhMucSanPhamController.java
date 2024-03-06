package com.shophandmade.controller.danhMucSanPham;

import com.shophandmade.entity.danhMucSanPhamEntity;
import com.shophandmade.service.danhMucSanPham.danhMucSanPhamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/danhMucSanPham")
@RequiredArgsConstructor
public class danhMucSanPhamController {

    private final danhMucSanPhamService danhMucSanPhamService;

    @GetMapping()
    public List<danhMucSanPhamEntity> layTatCaDMSP() {
        return danhMucSanPhamService.getAllDMSP();
    }

    @GetMapping("/{id}")
    public danhMucSanPhamEntity layDMSPBangId(@PathVariable Integer id) {
        return danhMucSanPhamService.getDMSPById(id);
    }

    @PostMapping("/them")
    public danhMucSanPhamEntity themMoiDMSP(@RequestBody danhMucSanPhamRequest danhMucSanPhamRequest) {
        return danhMucSanPhamService.saveDMSP(danhMucSanPhamRequest);
    }

    @PutMapping("/{id}")
    public danhMucSanPhamEntity capNhatDMSP(@PathVariable Integer id, @RequestBody danhMucSanPhamRequest danhMucSanPhamRequest) {
        return danhMucSanPhamService.updateDMSP(id, danhMucSanPhamRequest);
    }

    @DeleteMapping("/{id}")
    public String xoaDMSP(@PathVariable Integer id) {
        danhMucSanPhamService.deleteDMSP(id);
        return "Xoa danh muc san pham thanh cong";
    }

//    @PostMapping("/capNhat")
//    public ResponseEntity<String> capNhatDMSP(RequestBody Map<String, String> requestMap);

}
