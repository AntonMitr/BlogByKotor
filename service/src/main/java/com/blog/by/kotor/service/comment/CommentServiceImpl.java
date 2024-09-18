package com.blog.by.kotor.service.comment;

import com.blog.by.kotor.model.Comment;
import com.blog.by.kotor.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
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
    @Transactional
    public List<Comment> findCommentByPostId(Integer postId) {
        return commentRepository.findByPostId(postId);
    }

    @Override
    @Transactional
    public Comment getCommentById(Integer id) {
        return commentRepository.getReferenceById(id);
    }

    @Override
    @Transactional
    public List<Comment> getAllComment() {
        return commentRepository.findAll();
    }

    @Override
    @Transactional
    public void updateComment(Comment comment) {
        commentRepository.saveAndFlush(comment);
    }

    @Override
    @Transactional
    public void deleteCommentById(Integer id) {
        commentRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteComment(Comment comment) {
        commentRepository.delete(comment);
    }

}
