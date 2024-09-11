package com.blog.by.kotor.post.service;

import com.blog.by.kotor.Post;
import com.blog.by.kotor.PostDAO;

import java.util.List;

public class PostServiceImpl implements PostService {

    private final PostDAO postDAO;

    public PostServiceImpl() {
        postDAO = PostDAO.getPostDAO();
    }

    @Override
    public void createPost(Post post) {
        postDAO.create(post);
    }

    @Override
    public Post getPostById(int id) {
        return postDAO.getById(id);
    }

    @Override
    public List<Post> getAllPost() {
        return postDAO.getAll();
    }

    @Override
    public void updatePost(Post post) {
        postDAO.update(post);
    }

    @Override
    public void deletePostById(int id) {
        postDAO.deleteById(id);
    }

    @Override
    public void deletePost(Post post) {
        postDAO.delete(post);
    }

    @Override
    public void publishPost(Post post) {
        postDAO.publishPost(post);
    }

}
