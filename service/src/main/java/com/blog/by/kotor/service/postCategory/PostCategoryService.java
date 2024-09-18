package com.blog.by.kotor.service.postCategory;

import com.blog.by.kotor.model.postCategory.PostCategory;

import java.util.List;

public interface PostCategoryService {

    void createPostCategory(PostCategory postCategory);

    PostCategory getPostCategoryById(Integer id);

    List<PostCategory> getAllPostCategory();

    void updatePostCategory(PostCategory postCategory);

    void deletePostCategoryById(Integer id);

    void deletePostCategory(PostCategory postCategory);

}
