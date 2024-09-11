package com.blog.by.kotor.registration.service;

import com.blog.by.kotor.User;
import com.blog.by.kotor.UserDAO;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class RegistrationServiceImpl implements RegistrationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationServiceImpl.class);

    private final UserDAO userDAO;

    public RegistrationServiceImpl() {
        userDAO = UserDAO.getUserDAO();
    }

    @Override
    public boolean register(User user) {
        boolean result = true;

        if (user.getEmail() == null) {
            LOGGER.error("Почта не может быть null");
            return false;
        }

        if (user.getPassword() == null) {
            LOGGER.error("Пароль не может быть null");
        }

        if (user.getPassword().length() < 6) {
            LOGGER.error("Пароль должен содержать не менее 6 символов!");
            return false;
        }

        if (userDAO.findByEmail(user.getEmail())) {
            LOGGER.error("Данный пользователь уже существует!");
            return false;
        }
        userDAO.create(user);
        return result;
    }

}
