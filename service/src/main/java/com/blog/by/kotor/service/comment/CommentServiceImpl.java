package com.blog.by.kotor.service.comment;

import com.blog.by.kotor.model.Comment;
import com.blog.by.kotor.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Override
    @Transactional
    public void createComment(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Comment> findCommentByPostId(Integer postId) {
        return commentRepository.findByPostId(postId);
    }

    @Override
    @Transactional(readOnly = true)
    public Comment findCommentById(Integer id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Comment> findAllComment() {
        return commentRepository.findAll();
    }

    @Override
    @Transactional
    public void updateComment(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    @Modifying
    @Transactional
    public void deleteCommentById(Integer id) {
        commentRepository.deleteById(id);
    }

    @Override
    @Modifying
    @Transactional
    public void deleteComment(Comment comment) {
        commentRepository.delete(comment);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Comment> findByPostIdOrderByCreatedAt(Integer postId) {
        return commentRepository.findByPostIdOrderByCreatedAt(postId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Comment> findByUserIdOrderByCreatedAt(Integer userId) {
        return commentRepository.findByUserIdOrderByCreatedAt(userId);
    }

}
