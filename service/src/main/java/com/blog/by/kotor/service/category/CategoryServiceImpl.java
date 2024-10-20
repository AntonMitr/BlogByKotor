package com.blog.by.kotor.service.category;


import com.blog.by.kotor.CategoryDTOMapper;
import com.blog.by.kotor.dto.model.CategoryDTO;
import com.blog.by.kotor.exception.ErrorCode;
import com.blog.by.kotor.exception.create.CreateException;
import com.blog.by.kotor.exception.delete.DeleteException;
import com.blog.by.kotor.exception.find.by.id.FindByIdException;
import com.blog.by.kotor.exception.find.by.name.FindByNameException;
import com.blog.by.kotor.model.Category;
import com.blog.by.kotor.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryDTOMapper categoryDTOMapper;

    private final CategoryRepository categoryRepository;

    @Override
    public Category findCategoryById(Integer id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new FindByIdException(ErrorCode.CATEGORY_NOT_FOUND, id));
    }

    @Override
    public Category findByName(String name) {
        return categoryRepository.findByName(name)
                .orElseThrow(() -> new FindByNameException(ErrorCode.CATEGORY_NAME_NOT_FOUND, name));
    }

    @Override
    public List<Category> findAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    @Transactional
    public void createCategory(CategoryDTO categoryDTO) {
        if (categoryDTO.getName() == null) {
            throw new CreateException(ErrorCode.CATEGORY_NAME);
        }
        Category category = categoryDTOMapper.toCategory(categoryDTO);
        categoryRepository.save(category);
    }

    @Override
    @Transactional
    public void updateCategory(CategoryDTO categoryDTO, Integer id) {
        Category category = this.findCategoryById(id);
        categoryRepository.save(categoryDTOMapper.updateCategory(categoryDTO, category));
    }

    @Override
    @Transactional
    public void deleteCategoryById(Integer id) {
        categoryRepository.findById(id)
                .orElseThrow(() -> new DeleteException(ErrorCode.CATEGORY_NOT_FOUND, id));
        categoryRepository.deleteById(id);
    }

}
