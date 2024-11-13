package com.blog.by.kotor.service.category;

import com.blog.by.kotor.dto.model.CategoryDTO;
import com.blog.by.kotor.model.Category;

import java.util.List;

public interface CategoryService {

    Category findCategoryById(Integer id);

    Category findByName(String name);

    List<Category> findAllCategory();

    void createCategory(CategoryDTO categoryDTO);

    void updateCategory(CategoryDTO categoryDTO, Integer id);

    void deleteCategoryById(Integer id);

}
