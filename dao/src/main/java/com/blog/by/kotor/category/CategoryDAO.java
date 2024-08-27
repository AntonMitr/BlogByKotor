package com.blog.by.kotor.category;

import com.blog.by.kotor.Category;
import com.blog.by.kotor.DAO;

public interface CategoryDAO extends DAO<Category> {

    Category findByName(String name);

}
