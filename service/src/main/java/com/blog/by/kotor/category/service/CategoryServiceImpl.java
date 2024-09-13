package com.blog.by.kotor.category.service;

import com.blog.by.kotor.Category;
import com.blog.by.kotor.CategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryDAO categoryDAO;

    @Autowired
    public CategoryServiceImpl(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    @Override
    public Category getCategoryById(int id) {
        return categoryDAO.getById(id);
    }

    @Override
    @Transactional
    public List<Category> getAllCategory() {
        return categoryDAO.getAll();
    }

    @Override
    @Transactional
    public void createCategory(Category category) {
        categoryDAO.create(category);
    }

    @Override
    @Transactional
    public void updateCategory(Category category) {
        categoryDAO.update(category);
    }

    @Override
    @Transactional
    public void deleteCategoryById(int id) {
        categoryDAO.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteCategory(Category category) {
        categoryDAO.delete(category);
    }


}
