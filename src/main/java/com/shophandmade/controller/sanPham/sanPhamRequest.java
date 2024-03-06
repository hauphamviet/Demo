package com.shophandmade.controller.sanPham;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
@Getter
public class sanPhamRequest {

    @NotNull(message = "Ten khong duoc de chong")
    @Size(max = 30 )
    private String ten;

    @NotNull(message = "Gia khong duoc de chong")
    @Size(min=0,message="Giá tiền sản phẩm lớn hơn 0")
    private float gia;

    private String moTa;

    private Integer dmspId;

    private String trangThai;

}
