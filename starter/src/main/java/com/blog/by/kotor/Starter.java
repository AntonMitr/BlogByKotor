package com.blog.by.kotor;

import com.blog.by.kotor.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
public class Starter {

    static final Logger log = LoggerFactory.getLogger(Starter.class);

    public static void main( String[] args ) {
        log.info("Before Starting application");
        ConfigurableApplicationContext context = SpringApplication.run(Starter.class, args);
        log.debug("Starting my application in debug with {} args", args.length);
        log.info("Starting my application with {} args.", args.length);

        UserService userService = context.getBean(UserService.class);
        System.out.println(userService.findUserById(1).getName());

        context.close();
    }

}
