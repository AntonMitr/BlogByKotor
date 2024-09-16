package com.blog.by.kotor.service;

import com.blog.by.kotor.model.User;
import com.blog.by.kotor.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public void createUser(User user) {
        userDAO.create(user);
    }

    @Override
    @Transactional
    public User getUserById(int id) {
        return userDAO.getById(id);
    }

    @Override
    @Transactional
    public List<User> getAllUser() {
        return userDAO.getAll();
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userDAO.update(user);
    }

    @Override
    @Transactional
    public void deleteUserById(int id) {
        userDAO.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteUser(User user) {
        userDAO.delete(user);
    }

}
