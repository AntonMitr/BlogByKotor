package com.blog.by.kotor.category;

import com.blog.by.kotor.Category;
import com.blog.by.kotor.DAO;
import com.blog.by.kotor.DAOException;
import com.blog.by.kotor.DBException;

public interface CategoryDAO extends DAO<Category> {

    Category findByName(String name) throws DAOException, DBException;

}
