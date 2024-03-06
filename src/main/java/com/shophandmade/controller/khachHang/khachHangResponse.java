package com.shophandmade.controller.khachHang;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class khachHangResponse {

    private Integer id;

    private String tenTaiKhoan;

    private String hoTen;

    private Date ngaySinh;

    private String SDT;

    private String email;

    private String diaChi;

    private String trangThai;

    public khachHangResponse(Integer id, String tenTaiKhoan, String hoTen, Date ngaySinh, String SDT, String email,
                             String diaChi, String trangThai) {
        this.id = id;
        this.tenTaiKhoan = tenTaiKhoan;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.SDT = SDT;
        this.email = email;
        this.diaChi = diaChi;
        this.trangThai = trangThai;
    }

}
