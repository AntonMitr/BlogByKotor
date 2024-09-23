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
    @Transactional(readOnly = true)
    public Post findPostById(Integer id) {
        return postRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Post> findByUserId(Integer userId) {
        return postRepository.findByUserId(userId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Post> findByTitle(String title) {
        return postRepository.findByTitle(title);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Post> findByTitleOrderByDatePublished(String title) {
        return postRepository.findByTitleOrderByDatePublished(title);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Post> findByContentContainsOrderByDatePublished(String content) {
        return postRepository.findByContentContainsOrderByDatePublished(content);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Post> findAllPost() {
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
