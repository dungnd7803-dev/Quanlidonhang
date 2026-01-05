package com.example.Quanlydonhang.dao;

import com.example.Quanlydonhang.dto.response.PageResponse;

import java.util.Optional;

public interface DaoBase {
     public <T> void create(T entity);
     public <T> void delete(T entity);
     public <T> void update(T entity);
     public <T>Optional<T> getbyid(Class<T> clazz,long id);
     <T> PageResponse<T> findallwithPage(Class<T> clazz, int page, int size);
}
