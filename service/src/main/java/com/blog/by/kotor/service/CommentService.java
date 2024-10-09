package com.blog.by.kotor.service;

import com.blog.by.kotor.model.Comment;

import java.util.List;

public interface CommentService {

    void createComment(Comment comment);

    List<Comment> findCommentByPostId(int postId);

    Comment getCommentById(int id);

    List<Comment> getAllComment();

    void updateComment(Comment comment);

    void deleteCommentById(int id);

    void deleteComment(Comment comment);

}
