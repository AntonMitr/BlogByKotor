package com.blog.by.kotor.post.service;

import com.blog.by.kotor.Post;

public interface ImplPostService {

    void createPost(Post post);

    void updatePost(Post oldPost, Post newPost);

    void publishPost(Post post);

    boolean isPremium(Post post);
}
