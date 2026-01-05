package com.example.Quanlydonhang.service;

import com.example.Quanlydonhang.dto.request.RequestKhachHang;
import com.example.Quanlydonhang.dto.response.PageResponse;
import com.example.Quanlydonhang.dto.response.ResponseDao;
import com.example.Quanlydonhang.model.KhachHang;

public interface ServiceKhachHang {
    ResponseDao<?> create(RequestKhachHang requestKhachHang);
    ResponseDao<?> delete(long id);
    ResponseDao<?> update(long id, RequestKhachHang requestKhachHang);
    KhachHang getId(long id);
    PageResponse<KhachHang> getresultPage(int size, int page);
}
