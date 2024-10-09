package com.blog.by.kotor.service;

import com.blog.by.kotor.dao.CommentDAO;
import com.blog.by.kotor.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentDAO commentDAO;

    @Autowired
    public CommentServiceImpl(CommentDAO commentDAO) {
        this.commentDAO = commentDAO;
    }

    @Override
    @Transactional
    public void createComment(Comment comment) {
        commentDAO.create(comment);
    }

    @Override
    @Transactional
    public List<Comment> findCommentByPostId(int postId) {
        return commentDAO.findByPostId(postId);
    }

    @Override
    @Transactional
    public Comment getCommentById(int id) {
        return commentDAO.getById(id);
    }

    @Override
    @Transactional
    public List<Comment> getAllComment() {
        return commentDAO.getAll();
    }

    @Override
    @Transactional
    public void updateComment(Comment comment) {
        commentDAO.update(comment);
    }

    @Override
    @Transactional
    public void deleteCommentById(int id) {
        commentDAO.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteComment(Comment comment) {
        commentDAO.delete(comment);
    }

}
