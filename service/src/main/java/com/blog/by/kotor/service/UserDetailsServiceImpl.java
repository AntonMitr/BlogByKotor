package com.blog.by.kotor.service;

import com.blog.by.kotor.exception.find.by.name.FindByNameException;
import com.blog.by.kotor.model.User;
import com.blog.by.kotor.model.security.UserDetailsImpl;
import com.blog.by.kotor.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static com.blog.by.kotor.exception.ErrorCode.USER_NAME_NOT_FOUND;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user;
        try {
            user = userRepository.findByUsername(username)
                    .orElseThrow(() -> new UsernameNotFoundException("Пользователь с username: " + username + " не найден"));
        } catch (UsernameNotFoundException ex) {
            log.info("Пользователь не найден: {}", username);
            throw new FindByNameException(USER_NAME_NOT_FOUND, username);
        }
        return UserDetailsImpl.build(user);
    }

}
