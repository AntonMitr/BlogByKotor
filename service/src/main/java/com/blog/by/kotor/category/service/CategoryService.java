package com.blog.by.kotor.category.service;

import com.blog.by.kotor.Category;
import com.blog.by.kotor.CategoryDAO;

public class CategoryService implements ImplCategoryService {

    private final CategoryDAO categoryDAO;

    public CategoryService() {
        categoryDAO = new CategoryDAO();
    }

    @Override
    public void createCategory(Category category) {
        categoryDAO.create(category);
    }

}
