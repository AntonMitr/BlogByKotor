package com.blog.by.kotor.service.postCategory;

import com.blog.by.kotor.model.Post;
import com.blog.by.kotor.model.postCategory.PostCategory;

import java.util.List;

public interface PostCategoryService {

    void createPostCategory(PostCategory postCategory);

    List<PostCategory> findByCategoryId(Integer id);

    List<PostCategory> findByPostId(Integer id);

    List<PostCategory> findAllPostCategory();

    void updatePostCategory(PostCategory postCategory);

    void deletePostCategory(PostCategory postCategory);

}
