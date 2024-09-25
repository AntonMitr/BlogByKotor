package com.blog.by.kotor.post.service;

import com.blog.by.kotor.DAOException;
import com.blog.by.kotor.DBException;
import com.blog.by.kotor.Post;

public interface PostService {

    void createPost(Post post) throws DAOException, DBException;

    void updatePost(Post oldPost, Post newPost) throws DAOException, DBException;

    void publishPost(Post post) throws DAOException, DBException;

    boolean isPremium(Post post) throws DAOException, DBException;
}
