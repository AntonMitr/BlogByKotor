package com.blog.by.kotor.service.category;


import com.blog.by.kotor.exception.ErrorCode;
import com.blog.by.kotor.exception.NotNullParam;
import com.blog.by.kotor.exception.create.CreateException;
import com.blog.by.kotor.exception.create.CreateExceptionFactory;
import com.blog.by.kotor.exception.delete.DeleteExceptionFactory;
import com.blog.by.kotor.exception.find.by.id.FindByIdException;
import com.blog.by.kotor.exception.find.by.id.FindByIdExceptionFactory;
import com.blog.by.kotor.exception.find.by.name.FindByNameExceptionFactory;
import com.blog.by.kotor.exception.update.UpdateExceptionFactory;
import com.blog.by.kotor.model.Category;
import com.blog.by.kotor.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Category findCategoryById(Integer id) {
        return categoryRepository.findById(id).orElseThrow(() -> FindByIdExceptionFactory.moduleNotFound(ErrorCode.CATEGORY_NOT_FOUND, id));
    }

    @Override
    public Category findByName(String name) {
        return categoryRepository.findByName(name).orElseThrow(() -> FindByNameExceptionFactory.moduleNotFound(ErrorCode.CATEGORY_NOT_FOUND, name));
    }

    @Override
    public List<Category> findAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    @Transactional
    public void createCategory(Category category) {
        if(category.getId() == null) {
            throw CreateExceptionFactory.CategoryParamNotBeNull(NotNullParam.CATEGORY_ID);
        }
        if(category.getName() == null) {
            throw CreateExceptionFactory.CategoryParamNotBeNull(NotNullParam.CATEGORY_NAME);
        }
        categoryRepository.save(category);
    }

    @Override
    @Transactional
    public void updateCategory(Category category) {
        categoryRepository.findById(category.getId()).orElseThrow(() -> UpdateExceptionFactory.moduleNotFound(ErrorCode.CATEGORY_NOT_FOUND, category.getId()));
        categoryRepository.save(category);
    }

    @Override
    @Transactional
    public void deleteCategoryById(Integer id) {
        categoryRepository.findById(id).orElseThrow(() -> DeleteExceptionFactory.moduleNotFound(ErrorCode.CATEGORY_NOT_FOUND, id));
        categoryRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteCategory(Category category) {
        categoryRepository.findById(category.getId()).orElseThrow(() -> DeleteExceptionFactory.moduleNotFound(ErrorCode.CATEGORY_NOT_FOUND, category.getId()));
        categoryRepository.delete(category);
    }

}
