package com.blog.by.kotor;

import com.blog.by.kotor.category.CategoryDAO;
import com.blog.by.kotor.category.CategoryDAOImpl;

public class CategoryService {

    public void createCategory(Category category) {
        CategoryDAO categoryDAO = new CategoryDAOImpl();
        categoryDAO.insert(category);
    }

}
