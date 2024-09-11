package com.blog.by.kotor.login.service;

import com.blog.by.kotor.DAOException;
import com.blog.by.kotor.DBException;
import com.blog.by.kotor.user.UserDAOImpl;

public class LoginServiceImpl implements LoginService {

    public LoginServiceImpl() {
    }

    @Override
    public boolean login(String email, String password) throws DAOException, DBException {
        boolean result = true;

        if (UserDAOImpl.getUserDAOImpl().findByEmail(email) && UserDAOImpl.getUserDAOImpl().findByPassword(password)) {
            System.out.println("Добро пожаловать!");
        } else {
            System.out.println("Неправильный логин или пароль!");
            result = false;
        }
        return result;
    }

}
