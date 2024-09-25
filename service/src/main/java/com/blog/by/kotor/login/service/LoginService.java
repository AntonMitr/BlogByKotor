package com.blog.by.kotor.login.service;

import com.blog.by.kotor.DAOException;
import com.blog.by.kotor.DBException;
import com.blog.by.kotor.LoginException;

public interface LoginService {

    void login(String email, String password) throws DAOException, DBException, LoginException;

}
