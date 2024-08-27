package com.blog.by.kotor.post;

import com.blog.by.kotor.DAO;
import com.blog.by.kotor.Post;

import java.util.List;

public interface PostDAO extends DAO<Post> {

    List<Post> findByUserId(int userId);

    List<Post> findByTitle(String title);

    int publishPost(Post post);

    boolean isPremium(int postId);

}
