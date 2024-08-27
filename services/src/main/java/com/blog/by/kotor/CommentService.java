package com.blog.by.kotor;


import java.util.List;

public class CommentService {

    public void createComment(Comment comment) {
        CommentsDAO commentDAO = new CommentsDAO();
        commentDAO.create(comment);
    }

    public List<Comment> findCommentByPostId(int postId) {
        CommentsDAO commentDAO = new CommentsDAO();
        return commentDAO.findByPostId(postId);
    }

}
