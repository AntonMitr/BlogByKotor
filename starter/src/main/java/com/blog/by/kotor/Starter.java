package com.blog.by.kotor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Starter {

    private static final Logger LOGGER = LoggerFactory.getLogger(Starter.class);

    public static void main(String[] args) {

        UserDAO userDAO = new UserDAO();
        User user = userDAO.getById(1);
        System.out.println(user.getName());
    }

}
