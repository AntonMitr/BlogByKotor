package com.blog.by.kotor.comment;

import com.blog.by.kotor.Comment;
import com.blog.by.kotor.DAO;
import com.blog.by.kotor.DAOException;
import com.blog.by.kotor.DBException;

import java.util.List;

public interface CommentDAO extends DAO<Comment> {

    List<Comment> findByPostId(int postId) throws DAOException, DBException;

}
