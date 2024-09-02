package com.blog.by.kotor.category.service;

import com.blog.by.kotor.Category;
import com.blog.by.kotor.category.CategoryDAO;
import com.blog.by.kotor.category.CategoryDAOImpl;

public class CategoryService implements ImplCategoryService {

    private final CategoryDAO categoryDAO;

    public CategoryService() {
        categoryDAO = new CategoryDAOImpl();
    }

    @Override
    public void createCategory(Category category) {
        categoryDAO.insert(category);
    }

}
