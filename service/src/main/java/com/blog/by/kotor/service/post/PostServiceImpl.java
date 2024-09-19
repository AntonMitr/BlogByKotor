package com.blog.by.kotor.service.post;

import com.blog.by.kotor.model.Post;
import com.blog.by.kotor.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    @Transactional
    public void createPost(Post post) {
        postRepository.save(post);
    }

    @Override
    @Transactional
    public Post getPostById(Integer id) {
        return postRepository.getReferenceById(id);
    }

    @Override
    @Transactional
    public List<Post> getAllPost() {
        return postRepository.findAll();
    }

    @Override
    @Transactional
    public void updatePost(Post post) {
        postRepository.saveAndFlush(post);
    }

    @Override
    @Transactional
    public void deletePostById(Integer id) {
        postRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deletePost(Post post) {
        postRepository.delete(post);
    }

}
