package com.shophandmade.controller.donHang;

import com.shophandmade.entity.donHangEntity;
import com.shophandmade.service.donHang.donHangService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/donHang")
@RequiredArgsConstructor
public class donHangController {

    private final donHangService donHangService;

    @GetMapping()
    public List<donHangEntity> layTatCaDonHang() {
        return donHangService.getAllDonHang();
    }

    @GetMapping("/{id}")
    public donHangEntity layDonHangBangId(@PathVariable Integer id) {
        return donHangService.getDonHangById(id);
    }

    @GetMapping("hoTen")
    public List<donHangEntity> layDonHangBangIdKH(@RequestParam("hoTen") String hoTen) {
        return donHangService.getDonByKhachHang(hoTen);
    }

    @DeleteMapping("/{id}")
    public String xoaDonHang(@PathVariable Integer id) {
        donHangService.deleteDonHang(id);
        return "Xoa don hang thanh cong";
    }

    @PutMapping("/{id}")
    public donHangEntity capNhatStrangThaiDonHang(@PathVariable Integer id, @RequestBody donHangRequest donHangRequest) {
        return donHangService.updateDonHang(id, donHangRequest);
    }



}
