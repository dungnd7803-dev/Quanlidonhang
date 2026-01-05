package com.example.Quanlydonhang.controller;

import com.example.Quanlydonhang.dto.request.RequestChiTietDonHang;
import com.example.Quanlydonhang.dto.request.RequestDonHang;
import com.example.Quanlydonhang.dto.response.ResponseDao;
import com.example.Quanlydonhang.model.DonHang;
import com.example.Quanlydonhang.service.ServiceDonHang;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/DonHang")
public class ControllerDonHang {
    private final ServiceDonHang serviceDonHang;

    public ControllerDonHang(ServiceDonHang serviceDonHang) {
        this.serviceDonHang = serviceDonHang;
    }

    @PostMapping
    ResponseEntity<?> create(@RequestBody RequestDonHang donhang) {
        ResponseDao<?> ok = serviceDonHang.create(donhang);
        return ResponseEntity.ok(ok);
    }
    @GetMapping
    ResponseEntity<?> findbyid(long id){
        ResponseDao<?> ok = serviceDonHang.findbyid(id);
        return ResponseEntity.ok(ok);
    }
    @DeleteMapping
    ResponseEntity<?> delete(long id){
        ResponseDao<?> ok = serviceDonHang.delete(id);
       return ResponseEntity.ok(ok);
    }
}
