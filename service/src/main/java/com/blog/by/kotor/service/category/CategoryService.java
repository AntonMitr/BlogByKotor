package com.blog.by.kotor.service.category;

import com.blog.by.kotor.model.Category;

import java.util.List;

public interface CategoryService {

    Category getCategoryById(Integer id);

    List<Category> getAllCategory();

    void createCategory(Category category);

    void updateCategory(Category category);

    void deleteCategoryById(Integer id);

    void deleteCategory(Category category);

}
