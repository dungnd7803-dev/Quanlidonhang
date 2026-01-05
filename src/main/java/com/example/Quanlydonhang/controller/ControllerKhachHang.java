package com.example.Quanlydonhang.controller;

import com.example.Quanlydonhang.dto.request.RequestKhachHang;
import com.example.Quanlydonhang.dto.response.ResponseDao;
import com.example.Quanlydonhang.model.KhachHang;
import com.example.Quanlydonhang.service.ServiceKhachHang;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/v1/KhachHang")
public class ControllerKhachHang {

    private final ServiceKhachHang serviceKhachHang;

    public ControllerKhachHang(ServiceKhachHang serviceKhachHang) {
        this.serviceKhachHang = serviceKhachHang;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid RequestKhachHang requestKhachHang) {
        ResponseDao<?> ok = serviceKhachHang.create(requestKhachHang);
        return ResponseEntity.ok(ok);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam long id) {
        ResponseDao<?> ok = serviceKhachHang.delete(id);
        return ResponseEntity.ok(ok);
    }

    @GetMapping({"id"})
    public KhachHang getid(@PathVariable long id) {
        KhachHang ok = serviceKhachHang.getId(id);
        return ok;
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestParam long id,@RequestBody RequestKhachHang requestKhachHang) {
        ResponseDao<?> ok = serviceKhachHang.update(id,requestKhachHang);
        return ResponseEntity.ok(ok);


    }
}
