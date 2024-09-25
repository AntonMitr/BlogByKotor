package com.blog.by.kotor;

import com.blog.by.kotor.post.service.PostServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Starter {

    public static void main(String[] args) {

        PostServiceImpl postService = new PostServiceImpl();
        Post post = new Post();
        UserDAO userDAO = UserDAO.getUserDAO();
        User user = userDAO.getById(1);
        post.setContent("Hello world I love ItClopedia");
        post.setUser(user);
        postService.createPost(post);

        System.out.println(user.getEmail());
    }

}
