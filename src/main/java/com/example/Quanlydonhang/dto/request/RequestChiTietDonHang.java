package com.example.Quanlydonhang.dto.request;

import com.example.Quanlydonhang.model.DonHang;
import com.example.Quanlydonhang.model.SanPham;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RequestChiTietDonHang {
    private int id_sanPham;
    private int soLuong;

}

