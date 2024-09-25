package com.blog.by.kotor.login.service;

import com.blog.by.kotor.DAOException;
import com.blog.by.kotor.DBException;
import com.blog.by.kotor.LoginException;
import com.blog.by.kotor.user.UserDAOImpl;

import static com.blog.by.kotor.LoginException.LOGIN_CONFIRMED_TEXT;
import static com.blog.by.kotor.LoginException.LOGIN_FAILED_TEXT;

public class LoginServiceImpl implements LoginService {

    public LoginServiceImpl() {
    }

    @Override
    public void login(String email, String password) throws DAOException, DBException, LoginException {
        boolean result = true;

        if (UserDAOImpl.getUserDAOImpl().findByEmail(email) && UserDAOImpl.getUserDAOImpl().findByPassword(password)) {
            throw new LoginException(LOGIN_CONFIRMED_TEXT);
        } else {
            System.out.println("Неправильный логин или пароль!");
             throw new LoginException(LOGIN_FAILED_TEXT);
        }
    }

}
