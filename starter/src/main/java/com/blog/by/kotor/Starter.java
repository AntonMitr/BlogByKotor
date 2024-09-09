package com.blog.by.kotor;

import com.blog.by.kotor.category.service.CategoryService;
import com.blog.by.kotor.registration.service.RegistrationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Starter {

    private static final Logger LOGGER = LoggerFactory.getLogger(Starter.class);

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        RegistrationService registrationService = context.getBean(RegistrationService.class);

        User user = context.getBean(User.class);

        user.setId(10);
        user.setEmail("test@test.com");
        user.setName("Pavel");
        user.setPassword("123456");

        registrationService.register(user);

        context.close();
    }

}
