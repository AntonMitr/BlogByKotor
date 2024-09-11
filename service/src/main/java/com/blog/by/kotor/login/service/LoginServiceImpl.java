package com.blog.by.kotor.login.service;

import com.blog.by.kotor.UserDAO;

public class LoginServiceImpl implements LoginService {

    private final UserDAO userDAO;

    public LoginServiceImpl() {
        userDAO = UserDAO.getUserDAO();
    }

    @Override
    public boolean isLogin(String email, String password) {
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
