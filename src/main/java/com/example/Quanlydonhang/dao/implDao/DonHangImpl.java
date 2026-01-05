package com.example.Quanlydonhang.dao.implDao;

import com.example.Quanlydonhang.dao.DaoDonHang;
import com.example.Quanlydonhang.dao.DaoSanPham;
import com.example.Quanlydonhang.model.ChiTietDonHang;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DonHangImpl extends BaseDaoImpl implements DaoDonHang {
    String hql = "from ChiTietDonHang c where c.donHang.id = :idDonHang";

    public List<ChiTietDonHang> chiTietDonHangs(long id) {
        return getSession().createQuery(hql, ChiTietDonHang.class).setParameter("idDonHang", id)
                .getResultList();
    }
}
