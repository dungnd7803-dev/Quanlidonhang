package com.example.Quanlydonhang.dao;

import com.example.Quanlydonhang.model.ChiTietDonHang;

import java.util.List;

public interface DaoDonHang extends DaoBase{
    List<ChiTietDonHang> chiTietDonHangs(long id);
}
