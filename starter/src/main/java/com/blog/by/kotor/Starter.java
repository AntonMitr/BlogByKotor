package com.blog.by.kotor;

import com.blog.by.kotor.post.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Starter {

    private static final Logger LOGGER = LoggerFactory.getLogger(Starter.class);

    public static void main(String[] args) {

        PostDAO postDAO = new PostDAO();
        PostService postService = new PostService(postDAO);
        Post post = new Post();
        UserDAO userDAO = new UserDAO();
        User user = userDAO.getById(1);
        post.setContent("Hello world I love ItClopedia");
        post.setUser(user);
        postService.createPost(post);
    }

}
