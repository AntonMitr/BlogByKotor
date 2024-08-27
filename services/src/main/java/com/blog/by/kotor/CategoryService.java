package com.blog.by.kotor;

public class CategoryService {

    public void createCategory(Category category) {
        CategoryDAO categoryDAO = new CategoryDAO();
        categoryDAO.create(category);
    }

}
