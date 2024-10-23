package com.blog.by.kotor.service.category;


import com.blog.by.kotor.exception.ErrorCode;
import com.blog.by.kotor.exception.create.CreateException;
import com.blog.by.kotor.exception.delete.DeleteException;
import com.blog.by.kotor.exception.find.by.id.FindByIdException;
import com.blog.by.kotor.exception.find.by.name.FindByNameException;
import com.blog.by.kotor.exception.update.UpdateException;
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
        return categoryRepository.findById(id)
                .orElseThrow(() -> new FindByIdException(ErrorCode.CATEGORY_NOT_FOUND, id));
    }

    @Override
    public Category findByName(String name) {
        return categoryRepository.findByName(name)
                .orElseThrow(() -> new FindByNameException(ErrorCode.CATEGORY_NOT_FOUND, name));
    }

    @Override
    public List<Category> findAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    @Transactional
    public void createCategory(Category category) {
        if(category.getId() == null) {
            throw new CreateException(ErrorCode.CATEGORY_ID);
        }
        if(category.getName() == null) {
            throw new CreateException(ErrorCode.CATEGORY_NAME);
        }
        categoryRepository.save(category);
    }

    @Override
    @Transactional
    public void updateCategory(Category category) {
        categoryRepository.findById(category.getId())
                .orElseThrow(() -> new UpdateException(ErrorCode.CATEGORY_NOT_FOUND, category.getId()));
        categoryRepository.save(category);
    }

    @Override
    @Transactional
    public void deleteCategoryById(Integer id) {
        categoryRepository.findById(id)
                .orElseThrow(() -> new DeleteException(ErrorCode.CATEGORY_NOT_FOUND, id));
        categoryRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteCategory(Category category) {
        categoryRepository.findById(category.getId())
                .orElseThrow(() -> new DeleteException(ErrorCode.CATEGORY_NOT_FOUND, category.getId()));
        categoryRepository.delete(category);
    }

}
