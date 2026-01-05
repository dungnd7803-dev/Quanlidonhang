package com.example.Quanlydonhang.dto.request;

import com.example.Quanlydonhang.model.DonHang;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class RequestKhachHang {
    @NotBlank(message = "NOT_BLANK")
    @Size(min = 4,max = 30,message = "STRING_LENGTH_NAME")
    private String ten;
    @NotBlank(message = "NOT_BLANK")
    @Email(message = "EMAIL")
    private String email;
    @NotBlank(message = "NOT_BLANK")
    @Pattern(regexp = "\\d{11}",message = "PHONE_NUMBER")
    private String soDienThoai;
    private String diaChi;
}
