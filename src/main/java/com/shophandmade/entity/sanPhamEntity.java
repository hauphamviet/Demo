package com.shophandmade.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Table(name = "t_sanPham")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class sanPhamEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ten", length = 30, nullable = false)
    private String ten;

    @Column(name = "gia", nullable = false)
    private float gia;

    @Column(name = "moTa", length = 500)
    private String moTa;

//    @JsonIgnore
    @ManyToOne//(fetch = FetchType.EAGER)
    @JoinColumn(name = "dmsp_id", nullable = false)
    private danhMucSanPhamEntity danhmucsanphamEntity;

    @Column(name = "trangThai")
    private String trangThai;

}
