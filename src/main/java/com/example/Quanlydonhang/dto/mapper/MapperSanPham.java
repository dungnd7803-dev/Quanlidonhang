package com.example.Quanlydonhang.dto.mapper;

import com.example.Quanlydonhang.dto.request.RequestSanPham;
import com.example.Quanlydonhang.model.SanPham;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MapperSanPham {
    SanPham toEntity(RequestSanPham requestSanPham);
    void updateFromDto(RequestSanPham dto, @MappingTarget SanPham entity);
}
