package com.blog.by.kotor.comment.service;


import com.blog.by.kotor.Comment;
import com.blog.by.kotor.CommentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService implements ImplCommentService {

    private final CommentDAO commentDAO;

    @Autowired
    public CommentService(CommentDAO commentDAO) {
        this.commentDAO = commentDAO;
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
