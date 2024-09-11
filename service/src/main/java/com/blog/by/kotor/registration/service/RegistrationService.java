package com.blog.by.kotor.registration.service;

import com.blog.by.kotor.DAOException;
import com.blog.by.kotor.DBException;
import com.blog.by.kotor.User;

public interface RegistrationService {

    boolean register(User user) throws DAOException, DBException;

}
