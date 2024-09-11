package com.blog.by.kotor.comment.service;


import com.blog.by.kotor.Comment;
import com.blog.by.kotor.CommentDAO;

import java.util.List;

public class CommentServiceImpl implements CommentService {

    private final CommentDAO commentDAO;

    public CommentServiceImpl() {
        commentDAO = CommentDAO.getCommentDAO();
    }

    @Override
    public void createComment(Comment comment) {
        commentDAO.create(comment);
    }

    @Override
    public List<Comment> findCommentByPostId(int postId) {
        return commentDAO.findByPostId(postId);
    }

    @Override
    public Comment getCommentById(int id) {
        return commentDAO.getById(id);
    }

    @Override
    public List<Comment> getAllComment() {
        return commentDAO.getAll();
    }

    @Override
    public void updateComment(Comment comment) {
        commentDAO.update(comment);
    }

    @Override
    public void deleteCommentById(int id) {
        commentDAO.deleteById(id);
    }

    @Override
    public void deleteComment(Comment comment) {
        commentDAO.delete(comment);
    }

}
