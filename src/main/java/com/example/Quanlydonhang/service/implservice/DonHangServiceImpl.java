package com.example.Quanlydonhang.service.implservice;

import com.example.Quanlydonhang.dao.DaoDonHang;
import com.example.Quanlydonhang.dto.request.RequestChiTietDonHang;
import com.example.Quanlydonhang.dto.request.RequestDonHang;
import com.example.Quanlydonhang.dto.response.ResponseChiTietDonHang;
import com.example.Quanlydonhang.dto.response.ResponseDao;
import com.example.Quanlydonhang.model.ChiTietDonHang;
import com.example.Quanlydonhang.model.DonHang;
import com.example.Quanlydonhang.model.KhachHang;
import com.example.Quanlydonhang.model.SanPham;
import com.example.Quanlydonhang.service.ServiceDonHang;
import com.example.Quanlydonhang.service.ServiceKhachHang;
import com.example.Quanlydonhang.service.ServiceSanPham;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DonHangServiceImpl implements ServiceDonHang {
    private final DaoDonHang daoDonHang;
    private final ServiceKhachHang serviceKhachHang;
    private final ServiceSanPham serviceSanPham;

    public DonHangServiceImpl(DaoDonHang daoDonHang, ServiceKhachHang serviceKhachHang, ServiceSanPham serviceSanPham) {
        this.daoDonHang = daoDonHang;
        this.serviceKhachHang = serviceKhachHang;
        this.serviceSanPham = serviceSanPham;
    }

    @Override
    public ResponseDao<?> create(RequestDonHang requestDonHang) {

        KhachHang khachHang = serviceKhachHang.getId(requestDonHang.getId_khachhang());
        DonHang donHang = new DonHang();
        List<ChiTietDonHang> chiTietDonHangs = new ArrayList<>();
        for (RequestChiTietDonHang ctsp : requestDonHang.getChiTietDonHangs()) {
            SanPham sanPham = serviceSanPham.finbyid(ctsp.getId_sanPham());
            if (sanPham.getSoLuong() == 0) {
                throw new RuntimeException(sanPham.getTen() + " đã hết hàng.");
            } else {
                if(sanPham.getSoLuong() < ctsp.getSoLuong()) {throw new RuntimeException(sanPham.getTen() + " không đủ trong kho.");}
                ChiTietDonHang chiTietDonHang = new ChiTietDonHang();
                chiTietDonHang.setDonHang(donHang);
                chiTietDonHang.setSoLuong(ctsp.getSoLuong());
                chiTietDonHang.setSanPham(sanPham);
                serviceSanPham.minus_quantity(sanPham.getId(), ctsp.getSoLuong());
                chiTietDonHang.setDonGia(ctsp.getSoLuong() * sanPham.getGia());
                chiTietDonHangs.add(chiTietDonHang);
            }
            donHang.setKhachHang(khachHang);
            donHang.setChiTietDonHangs(chiTietDonHangs);
            daoDonHang.create(donHang);
        }
        return ResponseDao.ok(requestDonHang); }

    @Override
    public ResponseDao<?> findbyid(long id) {
        List<ResponseChiTietDonHang> responseChiTietDonHang = new ArrayList<>();
        List<ChiTietDonHang> chiTietDonHang = daoDonHang.chiTietDonHangs(id);
        for(ChiTietDonHang donHang : chiTietDonHang){
        ResponseChiTietDonHang ctdh = new ResponseChiTietDonHang();
        ctdh.setId_donhang(id);
        ctdh.setTen_khachhang(donHang.getDonHang().getKhachHang().getTen());
        ctdh.setTenSanPham(donHang.getSanPham().getTen());
        ctdh.setGia(donHang.getDonGia());
        ctdh.setSoluong(donHang.getSoLuong());
        responseChiTietDonHang.add(ctdh);
    }
        return ResponseDao.ok(responseChiTietDonHang);
    }

    @Override
    public ResponseDao<?> delete(long id) {
        DonHang donHang = daoDonHang.getbyid(DonHang.class,id).orElseThrow(()-> new RuntimeException("Không có id đơn hàng."));
        daoDonHang.delete(donHang);
        return ResponseDao.ok();
    }


}
