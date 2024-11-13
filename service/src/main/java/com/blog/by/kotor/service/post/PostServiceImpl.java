package com.blog.by.kotor.service.post;

import com.blog.by.kotor.PostDTOMapper;
import com.blog.by.kotor.dto.model.PostDTO;
import com.blog.by.kotor.exception.ErrorCode;
import com.blog.by.kotor.exception.find.by.id.FindByIdException;
import com.blog.by.kotor.model.Post;
import com.blog.by.kotor.repository.PostRepository;
import com.blog.by.kotor.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    private final UserService userService;

    private final PostDTOMapper postDTOMapper;

    @Override
    @Transactional
    public void createPost(PostDTO postDTO) {
        Post post = postDTOMapper.toPost(postDTO);
        post.setUser(userService.findUserById(postDTO.getUserId()));
        postRepository.save(post);
    }

    @Override
    public Post findPostById(Integer id) {
        return postRepository.findById(id).orElseThrow(() -> new FindByIdException(ErrorCode.POST_NOT_FOUND, id));
    }

    @Override
    public List<Post> findByUserId(Integer userId) {
        userService.findUserById(userId);
        return postRepository.findByUserId(userId);
    }

    @Override
    public List<Post> findByTitle(String title) {
        return postRepository.findByTitle(title);
    }

    @Override
    public List<Post> findByTitleOrderByDatePublished(String title) {
        return postRepository.findByTitleOrderByDatePublished(title);
    }

    @Override
    public List<Post> findByContentContainsOrderByDatePublished(String content) {
        return postRepository.findByContentContainsOrderByDatePublished(content);
    }

    @Override
    public List<Post> findAllPost() {
        return postRepository.findAll();
    }

    @Override
    @Transactional
    public void updatePost(PostDTO postDTO, Integer id) {
        Post post = this.findPostById(id);
        postRepository.save(postDTOMapper.updatePost(postDTO, post));
    }

    @Override
    @Transactional
    public void deletePostById(Integer id) {
        this.findPostById(id);
        postRepository.deleteById(id);
    }

}
