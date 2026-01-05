package com.example.Quanlydonhang.service.implservice;

import com.example.Quanlydonhang.dao.DaoKhachHang;
import com.example.Quanlydonhang.dto.mapper.MapperKhachHang;
import com.example.Quanlydonhang.dto.request.RequestKhachHang;
import com.example.Quanlydonhang.dto.response.ResponseDao;
import com.example.Quanlydonhang.model.KhachHang;
import com.example.Quanlydonhang.service.ServiceKhachHang;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class KhachHangserviceimpl implements ServiceKhachHang {
    private final DaoKhachHang daoKhachHang;
    private final MapperKhachHang mapperKhachHang;

    public KhachHangserviceimpl(DaoKhachHang daoKhachHang, MapperKhachHang mapperKhachHang) {
        this.daoKhachHang = daoKhachHang;
        this.mapperKhachHang = mapperKhachHang;
    }

    @Override
    public ResponseDao<?> create(RequestKhachHang requestKhachHang) {
        KhachHang khachHang = mapperKhachHang.toEntity(requestKhachHang);
        daoKhachHang.create(khachHang);
        return ResponseDao.ok(khachHang);

    }

    @Override
    public ResponseDao<?> delete(long id) {
        KhachHang khachHang = getId(id);
        daoKhachHang.delete(khachHang);
        return ResponseDao.ok(khachHang);
    }

    @Override
    public ResponseDao<?> update(long id ,RequestKhachHang requestKhachHang) {
        KhachHang khachHang = getId(id);
        mapperKhachHang.updateFromDto(requestKhachHang,khachHang);
        daoKhachHang.update(khachHang);
        return ResponseDao.ok(khachHang);
    }

    @Override
    public KhachHang getId(long id) {
        return daoKhachHang.getbyid(KhachHang.class,id).orElseThrow(()-> new RuntimeException("Không có id khách hàng."));
    }
}
