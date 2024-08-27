package com.blog.by.kotor;

import com.blog.by.kotor.comment.CommentDAO;
import com.blog.by.kotor.comment.CommentDAOImpl;

import java.util.List;

public class CommentService {

    public void createComment(Comment comment) {
        CommentDAO commentDAO = new CommentDAOImpl();
        commentDAO.insert(comment);
    }

    public List<Comment> findCommentByPostId(int postId) {
        CommentDAO commentDAO = new CommentDAOImpl();
        return commentDAO.findByPostId(postId);
    }

}
