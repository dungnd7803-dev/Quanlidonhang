package com.example.Quanlydonhang.dao.implDao;

import com.example.Quanlydonhang.dao.DaoBase;
import com.example.Quanlydonhang.dto.response.PageResponse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;
import java.util.Queue;

import static com.fasterxml.classmate.AnnotationOverrides.builder;

public abstract class BaseDaoImpl implements DaoBase {
    @PersistenceContext
    private EntityManager entityManager;

    Session getSession() {
        return entityManager.unwrap(Session.class);
    }

    @Override
    public <T> PageResponse<T> findallwithPage(Class<T> clazz, int page, int size) {
        String nameclass = clazz.getSimpleName();
        Query<T> query = getSession().createQuery("select t from " + nameclass + " t", clazz);
        query.setFirstResult((page - 1) * size);
        query.setMaxResults(size);

        List<T> data = query.list();
        Long totalItems = getSession()
                .createQuery("SELECT COUNT(e) FROM " + nameclass + " e", Long.class)
                .uniqueResult();
        int totalPages = (int) Math.ceil((double) totalItems / size);
        return PageResponse.<T>builder()
                .page(page)
                .size(size)
                .totalPage(totalPages)
                .totalItem(totalItems)
                .result(data)
                .build();
    }

    @Override
    public <T> void create(T entity) {
        getSession().persist(entity);
    }

    @Override
    public <T> void delete(T entity) {
        getSession().remove(entity);
    }

    @Override
    public <T> void update(T entity) {
        getSession().merge(entity);
    }

    @Override
    public <T> Optional<T> getbyid(Class<T> clazz, long id) {
        return Optional.ofNullable(getSession().get(clazz, id));
    }

}
