package com.blog.by.kotor.service.post;

import com.blog.by.kotor.model.Post;

import java.util.List;

public interface PostService {

    void createPost(Post post);

    Post findPostById(Integer postId);

    List<Post> findByUserId(Integer userId);

    List<Post> findByTitle(String title);

    List<Post> findByTitleOrderByDatePublished(String title);

    List<Post> findByContentContainsOrderByDatePublished(String content);

    List<Post> findAllPost();

    void updatePost(Post post);

    void deletePostById(Integer id);

    void deletePost(Post post);

}
