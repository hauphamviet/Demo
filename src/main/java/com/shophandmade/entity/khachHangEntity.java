package com.shophandmade.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;

@Entity
@Table(name = "t_users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class khachHangEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tenTaiKhoan",length = 50, unique = true)
    private String tenTaiKhoan;

    @JsonIgnore
    @Column(name = "matKhau", length = 200)
    private String matKhau;

    @Column(name = "hoTen", length = 50)
    private String hoTen;

    @Column(name = "ngaySinh")
    private Date ngaySinh;

    @Column(name = "SDT", length = 20, unique = true)
    private String SDT;

    @Email(message = "Email khong hop le")
    @Column(name = "email", length = 50, unique = true)
    private String email;

    @Column(name = "diaChi", length = 500)
    private String diaChi;

    @Column(name = "trangThai")
    private String trangThai;

    @Column(name = "role")
    private String role;

}
