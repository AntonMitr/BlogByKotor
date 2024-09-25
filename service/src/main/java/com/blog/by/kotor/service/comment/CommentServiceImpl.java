package com.blog.by.kotor.service.comment;

import com.blog.by.kotor.exception.ErrorCode;
import com.blog.by.kotor.exception.NotNullParam;
import com.blog.by.kotor.exception.create.CreateExceptionFactory;
import com.blog.by.kotor.exception.delete.DeleteExceptionFactory;
import com.blog.by.kotor.exception.find.by.id.FindByIdExceptionFactory;
import com.blog.by.kotor.exception.update.UpdateExceptionFactory;
import com.blog.by.kotor.model.Comment;
import com.blog.by.kotor.repository.CommentRepository;
import com.blog.by.kotor.repository.PostRepository;
import com.blog.by.kotor.repository.UserRepository;
import com.blog.by.kotor.service.post.PostService;
import com.blog.by.kotor.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final PostService postService;
    private final UserService userService;

    @Override
    @Transactional
    public void createComment(Comment comment) {
        if(comment.getId() == null){
            throw CreateExceptionFactory.CommentParamNotBeNull(NotNullParam.COMMENT_ID);
        }
        if(comment.getContent() == null){
            throw CreateExceptionFactory.CommentParamNotBeNull(NotNullParam.COMMENT_CONTENT);
        }
        if(comment.getPost().getId() == null){
            throw CreateExceptionFactory.CommentParamNotBeNull(NotNullParam.COMMENT_POST_ID);
        }
        if(comment.getUser().getId() == null){
            throw CreateExceptionFactory.CommentParamNotBeNull(NotNullParam.COMMENT_USER_ID);
        }
        if(comment.getCreatedAt() == null){
            throw CreateExceptionFactory.CommentParamNotBeNull(NotNullParam.COMMENT_CONTENT);
        }
        commentRepository.save(comment);
    }

    @Override
    public List<Comment> findCommentByPostId(Integer postId) {
        postService.findPostById(postId);
        return commentRepository.findByPostId(postId);
    }

    @Override
    public Comment findCommentById(Integer id) {
        return commentRepository.findById(id).orElseThrow(() -> FindByIdExceptionFactory.moduleNotFound(ErrorCode.COMMENT_NOT_FOUND, id));
    }

    @Override
    public List<Comment> findAllComment() {
        return commentRepository.findAll();
    }

    @Override
    @Transactional
    public void updateComment(Comment comment) {
        commentRepository.findById(comment.getId()).orElseThrow(() -> UpdateExceptionFactory.moduleNotFound(ErrorCode.COMMENT_NOT_FOUND, comment.getId()));
        commentRepository.save(comment);
    }

    @Override
    @Transactional
    public void deleteCommentById(Integer id) {
        commentRepository.findById(id).orElseThrow(() -> DeleteExceptionFactory.moduleNotFound(ErrorCode.COMMENT_NOT_FOUND, id));
        commentRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteComment(Comment comment) {
        commentRepository.findById(comment.getId()).orElseThrow(() -> DeleteExceptionFactory.moduleNotFound(ErrorCode.COMMENT_NOT_FOUND, comment.getId()));
        commentRepository.delete(comment);
    }

    @Override
    public List<Comment> findByPostIdOrderByCreatedAt(Integer postId) {
        postService.findPostById(postId);
        return commentRepository.findByPostIdOrderByCreatedAt(postId);
    }

    @Override
    public List<Comment> findByUserIdOrderByCreatedAt(Integer userId) {
        userService.findUserById(userId);
        return commentRepository.findByUserIdOrderByCreatedAt(userId);
    }

}
