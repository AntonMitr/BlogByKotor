package com.blog.by.kotor.login.service;

import com.blog.by.kotor.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoginServiceImpl implements LoginService {

    private final UserDAO userDAO;

    @Autowired
    public LoginServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
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
