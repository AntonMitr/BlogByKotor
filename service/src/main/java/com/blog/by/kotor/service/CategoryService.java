package com.blog.by.kotor.service;

import com.blog.by.kotor.model.Category;

import java.util.List;

public interface CategoryService {

    Category getCategoryById(int id);

    List<Category> getAllCategory();

    void createCategory(Category category);

    void updateCategory(Category category);

    void deleteCategoryById(int id);

    void deleteCategory(Category category);

}
