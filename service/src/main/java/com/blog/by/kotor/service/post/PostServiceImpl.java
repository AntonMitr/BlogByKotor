package com.blog.by.kotor.service.post;

import com.blog.by.kotor.exception.ErrorCode;
import com.blog.by.kotor.exception.create.CreateException;
import com.blog.by.kotor.exception.delete.DeleteException;
import com.blog.by.kotor.exception.find.by.id.FindByIdException;
import com.blog.by.kotor.exception.update.UpdateException;
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

    @Override
    @Transactional
    public void createPost(Post post) {
        if(post.getId() == null){
            throw new CreateException(ErrorCode.POST_ID);
        }
        if(post.getUser().getId() == null){
            throw new CreateException(ErrorCode.POST_USER_ID);
        }
        if(post.getContent() == null){
            throw new CreateException(ErrorCode.POST_CONTENT);
        }
        if(post.getTitle() == null){
            throw new CreateException(ErrorCode.POST_TITLE);
        }
        if(post.getDatePublished() == null){
            throw new CreateException(ErrorCode.POST_DATE_PUBLISHED);
        }
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
    public void updatePost(Post post) {
        postRepository.findById(post.getId())
                .orElseThrow(() -> new UpdateException(ErrorCode.POST_NOT_FOUND, post.getId()));
        postRepository.save(post);
    }

    @Override
    @Transactional
    public void deletePostById(Integer id) {
        postRepository.findById(id)
                .orElseThrow(() -> new DeleteException(ErrorCode.POST_NOT_FOUND, id));
        postRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deletePost(Post post) {
        postRepository.findById(post.getId())
                .orElseThrow(() -> new DeleteException(ErrorCode.POST_NOT_FOUND, post.getId()));
        postRepository.delete(post);
    }

}
