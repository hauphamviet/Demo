package com.shophandmade.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_chitietdonhang")
public class chiTietDonHangEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "gia")
    private float gia;

    @Column(name = "soLuong")
    private int soLuong;

    @Column(name = "thanhTien")
    private float thanhTien;

    @ManyToOne
    @JoinColumn(name = "donhang_id")
    private donHangEntity donhang;

    @ManyToOne
    @JoinColumn(name = "sanpham_id")
    private sanPhamEntity sanpham;

}
