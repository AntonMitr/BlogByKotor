package com.blog.by.kotor.service.comment;

import com.blog.by.kotor.dto.model.CommentDTO;
import com.blog.by.kotor.model.Comment;

import java.util.List;

public interface CommentService {

    void createComment(CommentDTO commentDTO);

    List<Comment> findCommentByPostId(Integer postId);

    Comment findCommentById(Integer id);

    List<Comment> findAllComment();

    void updateComment(CommentDTO commentDTO, Integer id);

    void deleteCommentById(Integer id);

    List<Comment> findByPostIdOrderByCreatedAt(Integer postId);

    List<Comment> findByUserIdOrderByCreatedAt(Integer userId);

}
