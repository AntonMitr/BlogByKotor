package com.blog.by.kotor;

import com.blog.by.kotor.model.User;
import com.blog.by.kotor.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class Starter {

    static final Logger log = LoggerFactory.getLogger(Starter.class);

    public static void main( String[] args ) {
        ConfigurableApplicationContext context = SpringApplication.run(Starter.class, args);

        UserService userService = context.getBean(UserService.class);

        User user = new User();
        user.setId(23);
        userService.createUser(user);

        context.close();
    }

}
