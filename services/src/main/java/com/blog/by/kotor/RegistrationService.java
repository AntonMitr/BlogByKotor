package com.blog.by.kotor;

import com.blog.by.kotor.user.UserDAO;
import com.blog.by.kotor.user.UserDAOImpl;

public class RegistrationService {

    public boolean register(User user) {
        boolean result = true;
        UserDAO userDAO = new UserDAOImpl();

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
