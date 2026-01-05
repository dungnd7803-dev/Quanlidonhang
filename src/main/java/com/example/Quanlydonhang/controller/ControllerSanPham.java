package com.example.Quanlydonhang.controller;

import com.example.Quanlydonhang.dto.request.ProductSearchRequest;
import com.example.Quanlydonhang.dto.request.RequestSanPham;
import com.example.Quanlydonhang.dto.response.PageResponse;
import com.example.Quanlydonhang.dto.response.ResponseDao;
import com.example.Quanlydonhang.model.SanPham;
import com.example.Quanlydonhang.service.ServiceSanPham;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/SanPham")
public class ControllerSanPham {
    private final ServiceSanPham serviceSanPham;

    public ControllerSanPham(ServiceSanPham serviceSanPham) {
        this.serviceSanPham = serviceSanPham;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody RequestSanPham requestSanPham) {
        ResponseDao<?> ok = serviceSanPham.create(requestSanPham);
        return ResponseEntity.ok(ok);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getid(@PathVariable long id) {
        SanPham ok = serviceSanPham.finbyid(id);
        return ResponseEntity.ok(ok);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam long id) {
        ResponseDao<?> ok = serviceSanPham.delete(id);
        return ResponseEntity.ok(ok);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestParam long id,@RequestBody RequestSanPham requestSanPham) {
        ResponseDao<?> ok = serviceSanPham.update(id,requestSanPham);
        return ResponseEntity.ok(ok);
    }
    @GetMapping
    public ResponseEntity<PageResponse<SanPham>> getSanPham(@RequestParam int page,@RequestParam int size){
        PageResponse<SanPham> sp = serviceSanPham.getresultPage(size,page);
        return ResponseEntity.ok(sp);
    }
    @GetMapping("/search")
    public ResponseEntity<PageResponse<SanPham>> Search( ProductSearchRequest productSearchRequest,
                                                        @RequestParam int page ,
                                                        @RequestParam int size){
        PageResponse<SanPham> sanpham = serviceSanPham.productSearch(productSearchRequest,page,size);
        return ResponseEntity.ok(sanpham);
    }
}
