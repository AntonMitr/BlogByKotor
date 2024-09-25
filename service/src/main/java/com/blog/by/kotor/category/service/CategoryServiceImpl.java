package com.blog.by.kotor.category.service;

import com.blog.by.kotor.Category;
import com.blog.by.kotor.CategoryDAO;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    CategoryDAO categoryDAO;
    
    public CategoryServiceImpl() {
        categoryDAO = CategoryDAO.getCategoryDAO();
    }

    @Override
    public Category getCategoryById(int id) {
        return categoryDAO.getById(id);
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryDAO.getAll();
    }

    @Override
    public void createCategory(Category category) {
        categoryDAO.create(category);
    }

    @Override
    public void updateCategory(Category category) {
        categoryDAO.update(category);
    }

    @Override
    public void deleteCategoryById(int id) {
        categoryDAO.deleteById(id);
    }

    @Override
    public void deleteCategory(Category category) {
        categoryDAO.delete(category);
    }


}
