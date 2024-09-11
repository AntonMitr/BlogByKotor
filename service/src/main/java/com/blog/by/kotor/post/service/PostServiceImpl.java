package com.blog.by.kotor.post.service;

import com.blog.by.kotor.DAOException;
import com.blog.by.kotor.DBException;
import com.blog.by.kotor.Post;
import com.blog.by.kotor.post.PostDAOImpl;

public class PostServiceImpl implements PostService {

    public PostServiceImpl() {
    }

    @Override
    public void createPost(Post post) throws DAOException, DBException {
        PostDAOImpl.getPostDAOImpl().insert(post);
    }

    @Override
    public void updatePost(Post oldPost, Post newPost) throws DAOException, DBException {
        PostDAOImpl.getPostDAOImpl().update(oldPost, newPost);
    }

    @Override
    public void publishPost(Post post) throws DAOException, DBException {
        PostDAOImpl.getPostDAOImpl().publishPost(post);
    }

    @Override
    public boolean isPremium(Post post) throws DAOException, DBException {
        return PostDAOImpl.getPostDAOImpl().isPremium(post.getId());
    }

}
