package com.blog.by.kotor.category.service;

import com.blog.by.kotor.Category;

import java.util.List;

public interface CategoryService {

    Category getCategoryById(int id);

    List<Category> getAllCategory();

    void createCategory(Category category);

    void updateCategory(Category category);

    void deleteCategoryById(int id);

    void deleteCategory(Category category);

}
