package com.example.Quanlydonhang.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseChiTietDonHang {
    long id_donhang;
    String ten_khachhang;
    String tenSanPham;
    double gia;
    int soluong;

}
