package com.blog.by.kotor.post;

import com.blog.by.kotor.DAO;
import com.blog.by.kotor.DAOException;
import com.blog.by.kotor.DBException;
import com.blog.by.kotor.Post;

import java.util.List;

public interface PostDAO extends DAO<Post> {

    List<Post> findByUserId(int userId) throws DAOException, DBException;

    List<Post> findByTitle(String title) throws DAOException, DBException;

    int publishPost(Post post) throws DAOException, DBException;

    boolean isPremium(int postId) throws DAOException, DBException;

}
