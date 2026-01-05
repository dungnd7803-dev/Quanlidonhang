package com.example.Quanlydonhang.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ProductSearchRequest {
    private String ten;
    private BigDecimal giaNhonhat;
    private BigDecimal giaLonnhat;
}
