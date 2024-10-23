package com.blog.by.kotor.service.registration;

import com.blog.by.kotor.exception.ErrorCode;
import com.blog.by.kotor.exception.create.CreateException;
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
            LOGGER.error("Почта не может быть null");
            throw new CreateException(ErrorCode.USER_EMAIL);
        }
        if (user.getPassword() == null) {
            LOGGER.error("Пароль не может быть null");
            throw new CreateException(ErrorCode.USER_PASSWORD);
        }
        if (user.getPassword().length() < 6) {
            LOGGER.error("Пароль должен содержать не менее 6 символов!");
            throw new RuntimeException("Пароль должен содержать не менее 6 символов!");
        }
        if (userRepository.findByEmail(user.getEmail())) {
            LOGGER.error("Данный пользователь уже существует!");
            throw new RuntimeException("Данный пользователь уже существует!");
        }

        userRepository.save(user);
        return result;
    }

}
