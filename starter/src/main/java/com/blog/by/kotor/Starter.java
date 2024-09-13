package com.blog.by.kotor;

import com.blog.by.kotor.role.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Starter {

    private static final Logger LOGGER = LoggerFactory.getLogger(Starter.class);

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        Role role = new Role();

        RoleService roleService = context.getBean(RoleService.class);

        role.setId(5);
        role.setName("ldknsdk");

        roleService.createRole(role);

        context.close();
    }

}
