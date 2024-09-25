package com.blog.by.kotor.service.postCategory;

import com.blog.by.kotor.model.postCategory.PostCategory;
import com.blog.by.kotor.repository.PostCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostCategoryServiceImpl implements PostCategoryService {

    private final PostCategoryRepository postCategoryRepository;

    @Override
    @Transactional
    public void createPostCategory(PostCategory postCategory) {
        postCategoryRepository.save(postCategory);
    }

    @Override
    public List<PostCategory> findByCategoryId(Integer id) {
        return postCategoryRepository.findByCategoryId(id);
    }

    @Override
    public List<PostCategory> findByPostId(Integer id) {
        return postCategoryRepository.findByPostId(id);
    }

    @Override
    public List<PostCategory> findAllPostCategory() {
        return postCategoryRepository.findAll();
    }

    @Override
    @Transactional
    public void updatePostCategory(PostCategory postCategory) {
        postCategoryRepository.save(postCategory);
    }

    @Override
    @Transactional
    public void deletePostCategoryById(Integer id) {
        postCategoryRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deletePostCategory(PostCategory postCategory) {
        postCategoryRepository.delete(postCategory);
    }
}
