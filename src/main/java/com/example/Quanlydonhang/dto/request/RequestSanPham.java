package com.example.Quanlydonhang.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RequestSanPham {
    @NotBlank(message = "NOT_BLANK")
    @Size(min = 4,max = 30,message = "STRING_LENGTH_NAME")
    private String ten;
    @NotBlank(message = "NOT_BLANK")
    @Min(value = 1000,message = "PRODUCT_PRICE")
    private Double gia;
    @Min(value = 1,message = "QUANTITY_PRODUCTS")
    @NotBlank(message = "NOT_BLANK")
    private Integer soLuong;
}
