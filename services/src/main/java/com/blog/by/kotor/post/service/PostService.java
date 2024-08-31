package com.blog.by.kotor.post.service;

import com.blog.by.kotor.Post;
import com.blog.by.kotor.post.PostDAO;
import com.blog.by.kotor.post.PostDAOImpl;

public class PostService implements ImplPostService{

    private final PostDAO postDAO;

    public PostService() {
        postDAO = new PostDAOImpl();
    }

    @Override
    public void createPost(Post post) {
        postDAO.insert(post);
    }

    @Override
    public void updatePost(Post oldPost, Post newPost) {
        postDAO.update(oldPost, newPost);
    }

    @Override
    public void publishPost(Post post) {
        postDAO.publishPost(post);
    }

    @Override
    public boolean isPremium(Post post) {
        return postDAO.isPremium(post.getId());
    }

}
