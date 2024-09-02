package com.blog.by.kotor.login.service;

import com.blog.by.kotor.user.UserDAO;
import com.blog.by.kotor.user.UserDAOImpl;

public class LoginService implements ImplLoginService {

    private final UserDAO userDAO;

    public LoginService() {
        userDAO = new UserDAOImpl();
    }

    @Override
    public boolean login(String email, String password) {
        boolean result = true;

        if (userDAO.findByEmail(email) && userDAO.findByPassword(password)) {
            System.out.println("Добро пожаловать!");
        } else {
            System.out.println("Неправильный логин или пароль!");
            result = false;
        }
        return result;
    }

}
