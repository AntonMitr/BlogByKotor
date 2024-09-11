package com.blog.by.kotor.postTag.service;

import com.blog.by.kotor.PostCategory.PostCategory;
import com.blog.by.kotor.PostCategoryDAO;
import com.blog.by.kotor.postCategory.service.PostCategoryService;

import java.util.List;

public class PostCategoryServiceImpl implements PostCategoryService {

    private final PostCategoryDAO postCategoryDAO;

    public PostCategoryServiceImpl() {
        postCategoryDAO = PostCategoryDAO.getPostCategoryDAO();
    }


    @Override
    public void createPostCategory(PostCategory postCategory) {
        postCategoryDAO.create(postCategory);
    }

    @Override
    public PostCategory getPostCategoryById(int id) {
        return postCategoryDAO.getById(id);
    }

    @Override
    public List<PostCategory> getAllPostCategory() {
        return postCategoryDAO.getAll();
    }

    @Override
    public void updatePostCategory(PostCategory postCategory) {
        postCategoryDAO.update(postCategory);
    }

    @Override
    public void deletePostCategoryById(int id) {
        postCategoryDAO.deleteById(id);
    }

    @Override
    public void deletePostCategory(PostCategory postCategory) {
        postCategoryDAO.delete(postCategory);
    }

}
