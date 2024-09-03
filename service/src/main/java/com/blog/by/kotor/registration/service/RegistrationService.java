package com.blog.by.kotor.registration.service;

import com.blog.by.kotor.User;
import com.blog.by.kotor.user.UserDAO;
import com.blog.by.kotor.user.UserDAOImpl;

public class RegistrationService implements ImplRegistrationService {

    private final UserDAO userDAO;

    public RegistrationService(UserDAOImpl userDAOImpl) {
        userDAO = userDAOImpl;
    }

    @Override
    public boolean register(User user) {
        boolean result = true;

        if (user.getEmail() == null || user.getPassword() == null) {
            System.out.println("Пароль не может быть нулевым!");
            return false;
        }

        if (user.getPassword().length() < 6) {
            System.out.println("Пароль должен содержать менее 6 символов!");
            return false;
        }

        if (userDAO.findByEmail(user.getEmail())) {
            System.out.println("Данный пользователь уже существует!");
            return false;
        }

        userDAO.insert(user);
        return result;
    }
}
