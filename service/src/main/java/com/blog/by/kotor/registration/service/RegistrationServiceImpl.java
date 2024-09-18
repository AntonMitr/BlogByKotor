package com.blog.by.kotor.registration.service;

import com.blog.by.kotor.DAOException;
import com.blog.by.kotor.DBException;
import com.blog.by.kotor.RegistrationException;
import com.blog.by.kotor.User;
import com.blog.by.kotor.user.UserDAOImpl;

import static com.blog.by.kotor.RegistrationException.*;

public class RegistrationServiceImpl implements RegistrationService {

    public RegistrationServiceImpl() {
    }


    @Override
    public boolean register(User user) throws DAOException, DBException, RegistrationException {
        boolean result = true;

        if (user.getEmail() == null) {
            throw new RegistrationException(REGISTRATION_NULL_EMAIL);
        }

        if (user.getPassword() == null) {
            throw new RegistrationException(REGISTRATION_NULL_PASSWORD);
        }

        if (user.getPassword().length() < 6) {
            throw new RegistrationException(REGISTRATION_SHORT_PASSWORD);
        }

        if (UserDAOImpl.getUserDAOImpl().findByEmail(user.getEmail())) {
            throw new RegistrationException(REGISTRATION_EXISTING_USER);
        }

        UserDAOImpl.getUserDAOImpl().insert(user);
        return result;
    }

}
