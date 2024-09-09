package com.blog.by.kotor.comment.service;

import com.blog.by.kotor.Comment;

import java.util.List;

public interface ImplCommentService {

    void createComment(Comment comment);

    List<Comment> findCommentByPostId(int postId);

}
