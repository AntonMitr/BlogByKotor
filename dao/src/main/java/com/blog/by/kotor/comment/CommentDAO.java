package com.blog.by.kotor.comment;

import com.blog.by.kotor.Comment;
import com.blog.by.kotor.DAO;

import java.util.List;

public interface CommentDAO extends DAO<Comment> {

    List<Comment> findByPostId(int postId);

}
