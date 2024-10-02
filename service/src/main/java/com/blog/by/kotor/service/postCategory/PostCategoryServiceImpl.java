package com.blog.by.kotor.service.postCategory;

import com.blog.by.kotor.exception.ErrorCode;
import com.blog.by.kotor.exception.create.CreateException;
import com.blog.by.kotor.model.postCategory.PostCategory;
import com.blog.by.kotor.repository.PostCategoryRepository;
import com.blog.by.kotor.service.category.CategoryService;
import com.blog.by.kotor.service.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostCategoryServiceImpl implements PostCategoryService {

    private final PostCategoryRepository postCategoryRepository;

    private final CategoryService categoryService;

    private final PostService postService;

    @Override
    @Transactional
    public void createPostCategory(PostCategory postCategory) {
        if(postCategory.getId().getCategoryId() == null){
            throw new CreateException(ErrorCode.POST_CATEGORY_CATEGORY_ID);
        }
        if(postCategory.getId().getPostId() == null){
            throw new CreateException(ErrorCode.POST_CATEGORY_POST_ID);
        }
        postCategoryRepository.save(postCategory);
    }

    @Override
    public List<PostCategory> findByCategoryId(Integer id) {
        categoryService.findCategoryById(id);
        return postCategoryRepository.findByCategoryId(id);
    }

    @Override
    public List<PostCategory> findByPostId(Integer id) {
        postService.findPostById(id);
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
    public void deletePostCategory(PostCategory postCategory) {
        postService.findPostById(postCategory.getId().getPostId());
        categoryService.findCategoryById(postCategory.getId().getCategoryId());
        postCategoryRepository.delete(postCategory);
    }
}
