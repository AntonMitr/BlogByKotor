package com.blog.by.kotor.category.service;

import com.blog.by.kotor.Category;
import com.blog.by.kotor.DAOException;
import com.blog.by.kotor.DBException;
import com.blog.by.kotor.category.CategoryDAOImpl;

public class CategoryServiceImpl implements CategoryService {

    public CategoryServiceImpl() {
    }

    @Override
    public void createCategory(Category category) throws DAOException, DBException {
        CategoryDAOImpl.getCategoryDAOImpl().insert(category);
    }

}
