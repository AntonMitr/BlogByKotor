package com.blog.by.kotor.comment.service;

import com.blog.by.kotor.Comment;
import com.blog.by.kotor.DAOException;
import com.blog.by.kotor.DBException;
import com.blog.by.kotor.comment.CommentDAOImpl;

import java.util.List;

public class CommentServiceImpl implements CommentService {

    public CommentServiceImpl() {
    }

    @Override
    public void createComment(Comment comment) throws DAOException, DBException {
        CommentDAOImpl.getCommentDAOImpl().insert(comment);
    }

    @Override
    public List<Comment> findCommentByPostId(int postId) throws DAOException, DBException {
        return CommentDAOImpl.getCommentDAOImpl().findByPostId(postId);
    }

}
