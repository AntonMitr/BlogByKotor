package com.blog.by.kotor.post.service;

import com.blog.by.kotor.Post;

public interface ImplPostService {

    void createPost(Post post);

    void updatePost(Post post);

    void publishPost(Post post);

}
