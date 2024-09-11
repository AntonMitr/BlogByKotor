package com.blog.by.kotor.postCategory.service;

import com.blog.by.kotor.PostCategory.PostCategory;

import java.util.List;

public interface PostCategoryService {

    void createPostCategory(PostCategory postCategory);

    PostCategory getPostCategoryById(int id);

    List<PostCategory> getAllPostCategory();

    void updatePostCategory(PostCategory postCategory);

    void deletePostCategoryById(int id);

    void deletePostCategory(PostCategory postCategory);
    
}
