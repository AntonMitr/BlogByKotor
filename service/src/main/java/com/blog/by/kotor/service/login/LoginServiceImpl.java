package com.blog.by.kotor.service.login;

import com.blog.by.kotor.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class LoginServiceImpl implements LoginService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public void isLogin(String email, String password) {

        if (userRepository.findByEmail(email) && userRepository.findByPassword(password)) {
            throw new RuntimeException("Добро пожаловать!");
        } else {
            throw new RuntimeException("Неправильный логин или пароль!");
        }
    }

}
