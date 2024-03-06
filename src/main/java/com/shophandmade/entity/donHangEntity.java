package com.shophandmade.entity;

import com.shophandmade.enums.trangThaiEnum;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "t_donhang")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class donHangEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "hoTen")
    private String hoTen;

    @Column(name = "SDT", length = 20)
    private String SDT;

    @Column(name = "diaChi")
    private String diaChi;

    @Email(message = "Email khong hop le")
    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "ngayDat")
    private LocalDateTime ngayDat;

    @Column(name = "ngayGiaoHang")
    private Date ngayGiaoHang;

    @Column(name = "ghiChu", columnDefinition = "TEXT")
    private String ghiChu;

    @Column(name = "phuongThucVanChuyen")
    private String phuongThucVanChuyen;

    @Column(name = "phuongThucThanhToan")
    private String phuongThucThanhToan;

    @Column(name = "tongTien")
    private float tongTien;

    @Column(name = "trangThai")
    @Enumerated(EnumType.STRING)
    private trangThaiEnum trangThai;

    @ManyToOne
    @JoinColumn(name = "khachang_id")
    private khachHangEntity khachhang;

}
