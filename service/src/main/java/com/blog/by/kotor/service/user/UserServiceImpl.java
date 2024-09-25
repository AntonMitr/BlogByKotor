package com.blog.by.kotor.service.user;

import com.blog.by.kotor.exception.ErrorCode;
import com.blog.by.kotor.exception.delete.DeleteExceptionFactory;
import com.blog.by.kotor.exception.find.by.id.FindByIdExceptionFactory;
import com.blog.by.kotor.exception.update.UpdateExceptionFactory;
import com.blog.by.kotor.model.User;
import com.blog.by.kotor.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public void createUser(User user) {
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

}
