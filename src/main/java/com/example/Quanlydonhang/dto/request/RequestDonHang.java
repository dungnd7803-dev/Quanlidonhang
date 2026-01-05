package com.example.Quanlydonhang.dto.request;

import com.example.Quanlydonhang.model.ChiTietDonHang;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RequestDonHang {
    private long id_khachhang;
    @NotBlank(message = "NOT_BLANK")
    private List<RequestChiTietDonHang> chiTietDonHangs;
}
