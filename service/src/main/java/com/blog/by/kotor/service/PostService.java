package com.blog.by.kotor.service;

import com.blog.by.kotor.model.Post;

import java.util.List;

public interface PostService {

    void createPost(Post post);

    Post getPostById(int id);

    List<Post> getAllPost();

    void updatePost(Post post);

    void deletePostById(int id);

    void deletePost(Post post);

    void publishPost(Post post);

}
