package com.blog.by.kotor.service.post;

import com.blog.by.kotor.dto.model.PostDTO;
import com.blog.by.kotor.model.Post;

import java.util.List;

public interface PostService {

    void createPost(PostDTO postDTO);

    Post findPostById(Integer postId);

    List<Post> findByUserId(Integer userId);

    List<Post> findByTitle(String title);

    List<Post> findByTitleOrderByDatePublished(String title);

    List<Post> findAllPost();

    void updatePost(PostDTO postDTO, Integer id);

    List<Post> findByContentContainsOrderByDatePublished(String content);

    void deletePostById(Integer id);

}
