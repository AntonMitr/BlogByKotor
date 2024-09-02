package com.blog.by.kotor.comment.service;


import com.blog.by.kotor.Comment;
import com.blog.by.kotor.CommentDAO;

import java.util.List;

public class CommentService implements ImplCommentService {

    private final CommentDAO commentDAO;

    public CommentService() {
        commentDAO = new CommentDAO();
    }

    @Override
    public void createComment(Comment comment) {
        commentDAO.create(comment);
    }

    @Override
    public List<Comment> findCommentByPostId(int postId) {
        return commentDAO.findByPostId(postId);
    }

}
