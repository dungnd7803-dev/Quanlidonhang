package com.example.Quanlydonhang.dto.mapper;

import com.example.Quanlydonhang.dto.request.RequestKhachHang;
import com.example.Quanlydonhang.dto.request.RequestSanPham;
import com.example.Quanlydonhang.model.KhachHang;
import com.example.Quanlydonhang.model.SanPham;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MapperKhachHang {
    KhachHang toEntity(RequestKhachHang request);
    void updateFromDto(RequestKhachHang dto, @MappingTarget KhachHang entity);
}
