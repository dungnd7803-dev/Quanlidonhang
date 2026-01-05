package com.example.Quanlydonhang.service;

import com.example.Quanlydonhang.dto.request.RequestChiTietDonHang;
import com.example.Quanlydonhang.dto.request.RequestDonHang;
import com.example.Quanlydonhang.dto.response.ResponseDao;
import com.example.Quanlydonhang.model.ChiTietDonHang;
import com.example.Quanlydonhang.model.DonHang;

public interface ServiceDonHang {
    ResponseDao<?> create(RequestDonHang chiTietDonHang);
    ResponseDao<?> findbyid(long id);
    ResponseDao<?> delete(long id);
}
