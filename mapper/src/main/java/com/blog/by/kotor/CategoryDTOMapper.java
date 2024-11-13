package com.blog.by.kotor;

import com.blog.by.kotor.dto.model.CategoryDTO;
import com.blog.by.kotor.model.Category;
import org.springframework.stereotype.Service;

@Service
public class CategoryDTOMapper {

    public Category toCategory(CategoryDTO categoryDTO) {
        return Category.builder()
                .name(categoryDTO.getName())
                .build();
    }

    public Category updateCategory(CategoryDTO categoryDTO, Category category) {
        if (categoryDTO.getName() != null) {
            category.setName(categoryDTO.getName());
        }
        return category;
    }

}
