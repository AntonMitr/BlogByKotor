package com.blog.by.kotor;

import com.blog.by.kotor.model.User;
import com.blog.by.kotor.service.login.LoginService;
import com.blog.by.kotor.service.role.RoleService;
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
        log.info("Before Starting application");
        ConfigurableApplicationContext context = SpringApplication.run(Starter.class, args);
        log.debug("Starting my application in debug with {} args", args.length);
        log.info("Starting my application with {} args.", args.length);

        UserService userService = context.getBean(UserService.class);
        LoginService loginService = context.getBean(LoginService.class);

        User user = userService.findUserById(1);

        loginService.isLogin(user.getEmail(), user.getPassword());

        context.close();
    }

}
