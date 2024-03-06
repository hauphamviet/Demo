package com.shophandmade.controller.donHang;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class chiTietDonHangRequest {

    @NotNull(message="Giá sản phẩm rỗng")
    @NotEmpty(message="Giá sản phẩm rỗng")
    @Size(min=0,message ="Giá sản phẩm từ 0 trở lên")
    private float gia;

    @NotNull(message = "Số lượng sản phẩm rỗng")
    @NotEmpty(message = "Số lượng sản phẩm rỗng")
    @Size(min = 1,message="Số lượng sản phẩm từ 1 trở lên")
    private int soLuong;

    private float thanhTien;

}
