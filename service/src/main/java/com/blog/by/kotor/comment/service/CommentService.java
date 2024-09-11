package com.blog.by.kotor.comment.service;

import com.blog.by.kotor.Comment;
import com.blog.by.kotor.DAOException;
import com.blog.by.kotor.DBException;

import java.util.List;

public interface CommentService {

    void createComment(Comment comment) throws DAOException, DBException;

    public List<Comment> findCommentByPostId(int postId) throws DAOException, DBException;

}
