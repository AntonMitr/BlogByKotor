package com.blog.by.kotor.post.service;

import com.blog.by.kotor.Post;
import com.blog.by.kotor.PostDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final PostDAO postDAO;

    @Autowired
    public PostServiceImpl(PostDAO postDAO) {
        this.postDAO = postDAO;
    }

    @Override
    @Transactional
    public void createPost(Post post) {
        postDAO.create(post);
    }

    @Override
    @Transactional
    public Post getPostById(int id) {
        return postDAO.getById(id);
    }

    @Override
    @Transactional
    public List<Post> getAllPost() {
        return postDAO.getAll();
    }

    @Override
    @Transactional
    public void updatePost(Post post) {
        postDAO.update(post);
    }

    @Override
    @Transactional
    public void deletePostById(int id) {
        postDAO.deleteById(id);
    }

    @Override
    @Transactional
    public void deletePost(Post post) {
        postDAO.delete(post);
    }

    @Override
    @Transactional
    public void publishPost(Post post) {
        postDAO.publishPost(post);
    }

}
