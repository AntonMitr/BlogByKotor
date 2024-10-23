package com.blog.by.kotor.service.category;

import com.blog.by.kotor.model.Category;

import java.util.List;

public interface CategoryService {

    void deleteCategory(Category category);

    Category findCategoryById(Integer id);

    Category findByName(String name);

    List<Category> findAllCategory();

    void createCategory(Category category);

    void updateCategory(Category category);

    void deleteCategoryById(Integer id);

}
