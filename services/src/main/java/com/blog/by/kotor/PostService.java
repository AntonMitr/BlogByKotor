package com.blog.by.kotor;

public class PostService {

    public void createPost(Post post) {
        PostDAO postDAO = new PostDAO();
        postDAO.create(post);
    }

    public void updatePost(Post post) {
        PostDAO postDAO = new PostDAO();
        postDAO.update(post);
    }

    public void publishPost(Post post) {
        PostDAO postDAO = new PostDAO();
        postDAO.publishPost(post);
    }

}
