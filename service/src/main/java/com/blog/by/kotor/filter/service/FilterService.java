package com.blog.by.kotor.filter.service;

import com.blog.by.kotor.DAOException;
import com.blog.by.kotor.DBException;
import com.blog.by.kotor.Post;

import java.util.List;

public interface FilterService {

    List<Post> findByTagCriteria(String criteria) throws DAOException, DBException;

    List<Post> findByCategoryCriteria(String criteria) throws DAOException, DBException;

}
