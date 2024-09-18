package com.blog.by.kotor.service.post;

import com.blog.by.kotor.model.Post;

import java.util.List;

public interface PostService {

    void createPost(Post post);

    Post getPostById(Integer id);

    List<Post> getAllPost();

    void updatePost(Post post);

    void deletePostById(Integer id);

    void deletePost(Post post);

    void publishPost(Post post);

}
