package com.blog.by.kotor.service.category;

import com.blog.by.kotor.repository.CategoryRepository;
import com.blog.by.kotor.model.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Category getCategoryById(Integer id) {
        return categoryRepository.getReferenceById(id);
    }

    @Override
    @Transactional
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    @Transactional
    public void createCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    @Transactional
    public void updateCategory(Category category) {
        categoryRepository.saveAndFlush(category);
    }

    @Override
    @Transactional
    public void deleteCategoryById(Integer id) {
        categoryRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteCategory(Category category) {
        categoryRepository.delete(category);
    }


}
