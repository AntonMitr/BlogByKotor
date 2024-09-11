package com.blog.by.kotor.filter;

import com.blog.by.kotor.DAO;
import com.blog.by.kotor.DAOException;
import com.blog.by.kotor.DBException;
import com.blog.by.kotor.Filter;

public interface FilterDAO extends DAO<Filter> {

    Filter findByCriteria(String criteria) throws DAOException, DBException;

}
