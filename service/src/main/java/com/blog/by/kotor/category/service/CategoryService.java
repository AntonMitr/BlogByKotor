package com.blog.by.kotor.category.service;

import com.blog.by.kotor.Category;
import com.blog.by.kotor.DAOException;
import com.blog.by.kotor.DBException;

public interface CategoryService {

    void createCategory(Category category) throws DAOException, DBException;

}
