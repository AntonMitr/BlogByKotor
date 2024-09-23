package com.blog.by.kotor.service.registration;

import com.blog.by.kotor.model.User;
import com.blog.by.kotor.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class RegistrationServiceImpl implements RegistrationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationServiceImpl.class);

    private final UserRepository userRepository;

    @Override
    @Transactional
    public boolean register(User user) {
        boolean result = true;

        if (user.getEmail() == null) {
            result = false;
            LOGGER.error("Почта не может быть null");
        }

        if (user.getPassword() == null) {
            result = false;
            LOGGER.error("Пароль не может быть null");
        }

        if (user.getPassword().length() < 6) {
            result = false;
            LOGGER.error("Пароль должен содержать не менее 6 символов!");
        }

        if (userRepository.findByEmail(user.getEmail())) {
            result = false;
            LOGGER.error("Данный пользователь уже существует!");
        }

        userRepository.save(user);
        return result;
    }

}
