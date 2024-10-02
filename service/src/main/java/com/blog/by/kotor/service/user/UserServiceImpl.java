package com.blog.by.kotor.service.user;

import com.blog.by.kotor.exception.ErrorCode;
import com.blog.by.kotor.exception.NotNullParam;
import com.blog.by.kotor.exception.create.CreateExceptionFactory;
import com.blog.by.kotor.exception.delete.DeleteExceptionFactory;
import com.blog.by.kotor.exception.find.by.id.FindByIdExceptionFactory;
import com.blog.by.kotor.exception.update.UpdateExceptionFactory;
import com.blog.by.kotor.model.User;
import com.blog.by.kotor.repository.UserRepository;
import com.blog.by.kotor.service.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public void createUser(User user) {
        if (user.getId() == null) {
            throw CreateExceptionFactory.UserParamNotBeNull(NotNullParam.USER_ID);
        }
        if (user.getEmail() == null) {
            throw CreateExceptionFactory.UserParamNotBeNull(NotNullParam.USER_EMAIL);
        }
        if (user.getUsername() == null) {
            throw CreateExceptionFactory.UserParamNotBeNull(NotNullParam.USER_NAME);
        }
        if (user.getPassword() == null) {
            throw CreateExceptionFactory.UserParamNotBeNull(NotNullParam.USER_PASSWORD);
        }
        if (user.getCreatedAt() == null) {
            throw CreateExceptionFactory.UserParamNotBeNull(NotNullParam.USER_CREATED_AT);
        }
        userRepository.save(user);
    }

    @Override
    public User findUserById(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> FindByIdExceptionFactory.moduleNotFound(ErrorCode.USER_NOT_FOUND, id));
    }

    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userRepository.findById(user.getId()).orElseThrow(() -> UpdateExceptionFactory.moduleNotFound(ErrorCode.USER_NOT_FOUND, user.getId()));
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteUserById(Integer id) {
        userRepository.findById(id).orElseThrow(() -> DeleteExceptionFactory.moduleNotFound(ErrorCode.USER_NOT_FOUND, id));
        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteUser(User user) {
        userRepository.findById(user.getId()).orElseThrow(() -> DeleteExceptionFactory.moduleNotFound(ErrorCode.USER_NOT_FOUND, user.getId()));
        userRepository.deleteById(user.getId());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Пользователь с username: " + username + " не найден"));

        return UserDetailsImpl.build(user);
    }

}