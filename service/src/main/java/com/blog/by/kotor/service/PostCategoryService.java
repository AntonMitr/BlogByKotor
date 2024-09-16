package com.blog.by.kotor.service;

import com.blog.by.kotor.model.postCategory.PostCategory;

import java.util.List;

public interface PostCategoryService {

    void createPostCategory(PostCategory postCategory);

    PostCategory getPostCategoryById(int id);

    List<PostCategory> getAllPostCategory();

    void updatePostCategory(PostCategory postCategory);

    void deletePostCategoryById(int id);

    void deletePostCategory(PostCategory postCategory);

}
