package com.blog.by.kotor;

import com.blog.by.kotor.login.service.LoginService;
import com.blog.by.kotor.login.service.LoginServiceImpl;

public class Main {

    public static void main(String[] args) {
        LoginService loginService = new LoginServiceImpl();

        try {
            loginService.login("Anton1234@gmail.com","qwerty1");
        } catch (LoginException | DAOException | DBException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
