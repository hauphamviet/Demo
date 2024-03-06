package com.shophandmade.controller.donHang;

import com.shophandmade.entity.khachHangEntity;
import com.shophandmade.enums.trangThaiEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class donHangRequest {

    @NotNull(message = " Ho ten khach hang rong")
    @NotEmpty(message = "Ho ten khach hang rong")
    @Size(max = 30, message = "Ten khach hang khong qua 30 ky tu")
    private String hoTen;

    @NotNull(message = "So dien thoai rong")
    @NotEmpty(message = "So dien thoai rong")
    private String SDT;

    @NotNull(message = "Ten dia chi rong")
    @NotEmpty(message = "Ten dia chi rong")
    private String diaChi;

    @NotNull(message = "Email rong")
    @NotEmpty(message ="Email rong")
    @Email(message = "Email khong dung dinh dang")
    private String email;

//    @NotNull(message = "Date is required") // he thong tu cap nhat
//    @DateTimeFormat(pattern = "yyyy/MM/dd")
//    @Pattern(regexp = "^\\d{4}-\\d{2}-\\{2}", message = "Date must be in the format yyyy-MM-dd")
//    private LocalDateTime ngayDat;

    private Date ngayGiaoHang;

    private String ghiChu;

    private String phuongThucVanChuyen;

    private String phuongThucThanhToan;

    private float tongTien;

    private trangThaiEnum trangThai;

    private String khachhang;

    private List<chiTietDonHangRequest> chiTietDonHangRequests;

}
