package com.example.Quanlydonhang.dao;

import com.example.Quanlydonhang.dto.request.ProductSearchRequest;
import com.example.Quanlydonhang.model.SanPham;

import java.util.List;

public interface DaoSanPham extends DaoBase{
    public List<SanPham> ProductSearch(ProductSearchRequest prq, int page, int size);
    public long countProductSearch(ProductSearchRequest prq);
}
