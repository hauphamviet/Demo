package com.shophandmade.controller.khachHang;

import com.shophandmade.entity.khachHangEntity;
import com.shophandmade.service.khachHang.khachHangService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@CrossOrigin("*")
public class khachHangController {

    private final khachHangService khachHangService;
    private final UserDetailsService userDetailsService;

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody(required = true) Map<String, String> requestMap) {
        return khachHangService.signUp(requestMap);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody(required = true) @Valid Map<String, String> requestMap) {
        return khachHangService.login(requestMap);
    }

    @GetMapping("/checkToken")
    public ResponseEntity<Map<String, String>> checkToken() {
        return khachHangService.checkToken();
    }

//    {
//        status: uadgadshdsam
//    }

    @GetMapping()
    public List<khachHangEntity> layTatCaKH() {
        return khachHangService.getAllKH();
    }

    @GetMapping("/{id}")
    public khachHangEntity layKHBangId(@PathVariable Integer id) {
        return khachHangService.getKHById(id);
    }

    @GetMapping("/email/{email}")
    public khachHangEntity layKHBangEmail(@PathVariable String email) {
        return khachHangService.findByEmail(email);
    }

    @GetMapping("/hoTen/{hoTen}")
    public khachHangEntity timTenKhachHang(@PathVariable String hoTen) {
        return khachHangService.findByHoTen(hoTen);
    }

    @PutMapping("/update/{id}")
    public khachHangEntity capNhatKhachHang(@PathVariable Integer id, @RequestBody khachHangRequest khachHangRequest) {
        return khachHangService.updateKhachHang(id, khachHangRequest);
    }

    @DeleteMapping("/{id}")
    public String xoaKhachHang(@PathVariable Integer id) {
        khachHangService.deleteKhachHang(id);
        return "Xoa khach hang thang cong";
    }

    @GetMapping("/KH")
    public List<khachHangEntity> layTatCaKhachHang() {
        return khachHangService.layTatCaKhachHang();
    }

    @GetMapping("/sdt/{sdt}")
    public khachHangEntity layKhachHangBangSDT(@PathVariable String sdt) {
        return khachHangService.findBySDT(sdt);
    }

}
