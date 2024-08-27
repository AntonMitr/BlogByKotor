package com.blog.by.kotor;

import java.util.List;

public interface DAO<T> {
    T findById(int id);

    List<T> getAll();

    int insert(T obj);

    int update(T oldObj, T newObj);

    int delete(T obj);

}
