package com.blog.by.kotor.comment.service;

import com.blog.by.kotor.Comment;
import com.blog.by.kotor.comment.CommentDAO;
import com.blog.by.kotor.comment.CommentDAOImpl;

import java.util.List;

public class CommentService implements ImplCommentService {

    private final CommentDAO commentDAO;

    public CommentService(CommentDAOImpl commentDAOImpl) {
        commentDAO = commentDAOImpl;
    }

    @Override
    public void createComment(Comment comment) {
        commentDAO.insert(comment);
    }

    @Override
    public List<Comment> findCommentByPostId(int postId) {
        return commentDAO.findByPostId(postId);
    }

}
