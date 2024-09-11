package com.blog.by.kotor.registration.service;

import com.blog.by.kotor.DAOException;
import com.blog.by.kotor.DBException;
import com.blog.by.kotor.User;
import com.blog.by.kotor.user.UserDAOImpl;

public class RegistrationServiceImpl implements RegistrationService {

    public RegistrationServiceImpl() {
    }

    @Override
    public boolean register(User user) throws DAOException, DBException {
        boolean result = true;

        if (user.getEmail() == null || user.getPassword() == null) {
            System.out.println("Пароль не может быть нулевым!");
            return false;
        }

        if (user.getPassword().length() < 6) {
            System.out.println("Пароль должен содержать менее 6 символов!");
            return false;
        }

        if (UserDAOImpl.getUserDAOImpl().findByEmail(user.getEmail())) {
            System.out.println("Данный пользователь уже существует!");
            return false;
        }

        UserDAOImpl.getUserDAOImpl().insert(user);
        return result;
    }
}
