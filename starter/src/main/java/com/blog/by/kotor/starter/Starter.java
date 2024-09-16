package com.blog.by.kotor.starter;

import com.blog.by.kotor.service.UserService;
import com.blog.by.kotor.spring.MyConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Starter {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        UserService userService = context.getBean(UserService.class);

        System.out.println(userService.getUserById(3).getName());

        context.close();
    }

}
