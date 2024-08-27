package com.blog.by.kotor;

import com.blog.by.kotor.user.UserDAO;
import com.blog.by.kotor.user.UserDAOImpl;

public class LoginService {

    public boolean login(String email, String password) {
        boolean result = true;
        UserDAO userDAO = new UserDAOImpl();

        if (userDAO.findByEmail(email) && userDAO.findByPassword(password)) {
            System.out.println("Добро пожаловать!");
        } else {
            System.out.println("Неправильный логин или пароль!");
            result = false;
        }
        return result;
    }

}
