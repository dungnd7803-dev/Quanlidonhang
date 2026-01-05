package com.example.Quanlydonhang.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor

@Table(name = "chi_tiet_don_hang")
public class ChiTietDonHang extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idDonHang")
    private DonHang donHang;

    @ManyToOne
    @JoinColumn(name = "idSanPham")
    private SanPham sanPham;

    private Integer soLuong;
    private Double donGia;
}


