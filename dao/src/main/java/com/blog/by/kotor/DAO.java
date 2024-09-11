package com.blog.by.kotor;

import java.util.List;

public interface DAO<T> {
    T findById(int id) throws DAOException, DBException;

    List<T> getAll() throws DAOException, DBException;

    int insert(T obj) throws DAOException, DBException;

    int update(T oldObj, T newObj) throws DAOException, DBException;

    int delete(T obj) throws DAOException, DBException;

}
