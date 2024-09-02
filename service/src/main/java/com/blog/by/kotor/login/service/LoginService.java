package com.blog.by.kotor.login.service;

import com.blog.by.kotor.UserDAO;

public class LoginService implements ImplLoginService {

    private boolean result;

    private UserDAO userDAO;

    public LoginService() {
        userDAO = new UserDAO();
        result = true;
    }

    @Override
    public boolean loginBool(String email, String password) {

        if (userDAO.findByEmail(email) && userDAO.findByPassword(password)) {
            System.out.println("Добро пожаловать!");
        } else {
            System.out.println("Неправильный логин или пароль!");
            result = false;
        }
        return result;
    }

}
