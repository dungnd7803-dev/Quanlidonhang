package com.example.Quanlydonhang.service.implservice;

import com.example.Quanlydonhang.dao.DaoSanPham;
import com.example.Quanlydonhang.dto.mapper.MapperSanPham;
import com.example.Quanlydonhang.dto.request.ProductSearchRequest;
import com.example.Quanlydonhang.dto.request.RequestSanPham;
import com.example.Quanlydonhang.dto.response.PageResponse;
import com.example.Quanlydonhang.dto.response.ResponseDao;
import com.example.Quanlydonhang.model.SanPham;
import com.example.Quanlydonhang.service.ServiceSanPham;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class SanPhamServiceImp implements ServiceSanPham {
    private final MapperSanPham mapperSanPham;
    private final DaoSanPham daoSanPham;

    public SanPhamServiceImp(MapperSanPham mapperSanPham, DaoSanPham daoSanPham) {
        this.mapperSanPham = mapperSanPham;
        this.daoSanPham = daoSanPham;
    }

    @Override
    public ResponseDao<?> create(RequestSanPham requestSanPham) {
        SanPham sanPham = mapperSanPham.toEntity(requestSanPham);
        daoSanPham.create(sanPham);
        return ResponseDao.ok(sanPham);
    }

    @Override
    public ResponseDao<?> delete(long id) {
        SanPham sanPham = finbyid(id);
        daoSanPham.delete(sanPham);
        return ResponseDao.ok(sanPham);
    }

    @Override
    public SanPham finbyid(long id) {
        return daoSanPham.getbyid(SanPham.class, id).orElseThrow(() -> new RuntimeException("Không có id sản phẩm."));
    }

    @Override
    public ResponseDao<?> update(long id, RequestSanPham requestSanPham) {
        SanPham sanPham = finbyid(id);
        mapperSanPham.updateFromDto(requestSanPham, sanPham);
        daoSanPham.update(sanPham);
        return ResponseDao.ok(requestSanPham);
    }

    public void minus_quantity(long idSP, int soluong) {
        SanPham sanPham = finbyid(idSP);
        sanPham.setSoLuong(sanPham.getSoLuong() - soluong);
    }

    @Override
    public PageResponse<SanPham> getresultPage(int size, int page) {
        return daoSanPham.findallwithPage(SanPham.class, page, size);
    }

    @Override
    public PageResponse<SanPham> productSearch(ProductSearchRequest productSearchRequest, int page, int size) {
        long count = daoSanPham.countProductSearch(productSearchRequest);
        List<SanPham> sanPhams = daoSanPham.ProductSearch(productSearchRequest, page, size);
        return PageResponse.<SanPham>builder()
                .result(sanPhams)
                .totalPage(page)
                .size(size)
                .totalItem(count)
                .build();
    }

}
