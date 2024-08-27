package com.blog.by.kotor;

import com.blog.by.kotor.post.PostDAO;
import com.blog.by.kotor.post.PostDAOImpl;

public class PostService {

    public void createPost(Post post) {
        PostDAO postDAO = new PostDAOImpl();
        postDAO.insert(post);
    }

    public void updatePost(Post post) {
        PostDAO postDAO = new PostDAOImpl();
        postDAO.update(post);
    }

    public void publishPost(Post post) {
        PostDAO postDAO = new PostDAOImpl();
        postDAO.publishPost(post);
    }

    public boolean isPremium(Post post) {
        PostDAO postDAO = new PostDAOImpl();
        return postDAO.isPremium(post.getId());
    }

}
