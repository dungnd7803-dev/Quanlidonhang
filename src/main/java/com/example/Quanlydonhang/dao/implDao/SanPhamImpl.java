package com.example.Quanlydonhang.dao.implDao;

import com.example.Quanlydonhang.dao.DaoSanPham;
import com.example.Quanlydonhang.dto.request.ProductSearchRequest;
import com.example.Quanlydonhang.model.SanPham;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SanPhamImpl extends BaseDaoImpl implements DaoSanPham {
    public String buildWhere(ProductSearchRequest prq) {
        StringBuilder sql = new StringBuilder(" WHERE 1=1");
        if (prq.getTen() != null && !prq.getTen().isBlank()) {
            sql.append(" AND lower(p.ten) LIKE :ten");
        }
        if (prq.getGiaNhonhat() != null) {
            sql.append(" AND p.gia >= :GiaNhonhat ");
        }
        if (prq.getGiaLonnhat() != null) {
            sql.append(" AND p.gia <= :GiaLonnhat ");
        }
         return sql.toString();
    }
    public void setparam(Query<?> qery,ProductSearchRequest prq){
        if (prq.getTen() != null && !prq.getTen().isBlank()) {
            qery.setParameter("ten", "%" + prq.getTen().toLowerCase() + "%");
        }
        if (prq.getGiaNhonhat() != null) {
            qery.setParameter("GiaNhonhat", prq.getGiaNhonhat());
        }
        if (prq.getGiaNhonhat() != null) {
            qery.setParameter("GiaLonnhat", prq.getGiaLonnhat());
        }
    }
    @Override
    public List<SanPham> ProductSearch(ProductSearchRequest prq, int page, int size){
        String sql = "SELECT p FROM SanPham p" + buildWhere(prq);
        Query<SanPham> sanPhamQuery = getSession().createQuery(sql, SanPham.class);
        setparam(sanPhamQuery,prq);
        sanPhamQuery.setFirstResult((page-1)*size);
        sanPhamQuery.setMaxResults(size);
        return sanPhamQuery.getResultList();
    }
    @Override
    public long countProductSearch(ProductSearchRequest prq){
        String hql = "SELECT COUNT(p.id) FROM SanPham p" + buildWhere(prq);
         Query<Long> query = getSession().createQuery(hql, Long.class);
         setparam(query,prq);
         return query.getSingleResult();
    }
}
