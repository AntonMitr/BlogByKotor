package com.blog.by.kotor.post.service;

import com.blog.by.kotor.Post;

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
