package com.shophandmade.controller.khachHang;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Setter
@Getter
public class khachHangRequest {

    private String tenTaiKhoan;

    private String hoTen;

    private Date ngaySinh;

    @NotNull(message = "SDT is required")
    @Size(max = 20)
    private String SDT;

    @Size(max = 20)
    @Email(message = "Email is valid")
    @NotNull(message = "Email is required")
    private String email;

    private String diaChi;

    private String trangThai;

}
