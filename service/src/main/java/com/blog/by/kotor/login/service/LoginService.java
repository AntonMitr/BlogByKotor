package com.blog.by.kotor.login.service;

import com.blog.by.kotor.DAOException;
import com.blog.by.kotor.DBException;

public interface LoginService {

    boolean login(String email, String password) throws DAOException, DBException;

}
