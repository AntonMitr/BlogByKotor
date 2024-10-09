package com.blog.by.kotor.service;

import com.blog.by.kotor.model.post.category.PostCategory;
import com.blog.by.kotor.dao.PostCategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class PosTagServiceImpl implements PostCategoryService {

    private final PostCategoryDAO postCategoryDAO;

    @Autowired
    public PosTagServiceImpl(PostCategoryDAO postCategoryDAO) {
        this.postCategoryDAO = postCategoryDAO;
    }

    @Override
    @Transactional
    public void createPostCategory(PostCategory postCategory) {
        postCategoryDAO.create(postCategory);
    }

    @Override
    @Transactional
    public PostCategory getPostCategoryById(int id) {
        return postCategoryDAO.getById(id);
    }

    @Override
    @Transactional
    public List<PostCategory> getAllPostCategory() {
        return postCategoryDAO.getAll();
    }

    @Override
    @Transactional
    public void updatePostCategory(PostCategory postCategory) {
        postCategoryDAO.update(postCategory);
    }

    @Override
    @Transactional
    public void deletePostCategoryById(int id) {
        postCategoryDAO.deleteById(id);
    }

    @Override
    @Transactional
    public void deletePostCategory(PostCategory postCategory) {
        postCategoryDAO.delete(postCategory);
    }

}
