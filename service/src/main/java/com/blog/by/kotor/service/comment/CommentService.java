package com.blog.by.kotor.service.comment;

import com.blog.by.kotor.model.Comment;

import java.util.List;

public interface CommentService {

    void createComment(Comment comment);

    List<Comment> findCommentByPostId(Integer postId);

    Comment getCommentById(Integer id);

    List<Comment> getAllComment();

    void updateComment(Comment comment);

    void deleteCommentById(Integer id);

    void deleteComment(Comment comment);

}
