package com.example.Quanlydonhang.service;

import com.example.Quanlydonhang.dto.request.ProductSearchRequest;
import com.example.Quanlydonhang.dto.request.RequestSanPham;
import com.example.Quanlydonhang.dto.response.PageResponse;
import com.example.Quanlydonhang.dto.response.ResponseDao;
import com.example.Quanlydonhang.model.SanPham;

public interface ServiceSanPham {
    ResponseDao<?> create(RequestSanPham requestSanPham);
    ResponseDao<?> delete(long id);
    SanPham finbyid(long id);
    ResponseDao<?> update(long id ,RequestSanPham requestSanPham);
    public void minus_quantity(long idSP, int soluong);
    PageResponse<SanPham> getresultPage(int size, int page);
    PageResponse<SanPham> productSearch(ProductSearchRequest productSearchRequest,int page, int size);
}
