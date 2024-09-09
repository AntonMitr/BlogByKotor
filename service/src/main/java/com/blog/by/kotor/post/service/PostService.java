package com.blog.by.kotor.post.service;

import com.blog.by.kotor.Post;
import com.blog.by.kotor.PostDAO;

public class PostService implements ImplPostService {

    private final PostDAO postDAO;

    public PostService(PostDAO postDAO) {
        this.postDAO = postDAO;
    }

    @Override
    public void createPost(Post post) {
        postDAO.create(post);
    }

    @Override
    public void updatePost(Post post) {
        postDAO.update(post);
    }

    @Override
    public void publishPost(Post post) {
        postDAO.publishPost(post);
    }

}
