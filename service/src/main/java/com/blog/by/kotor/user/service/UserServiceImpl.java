package com.blog.by.kotor.user.service;

import com.blog.by.kotor.User;
import com.blog.by.kotor.UserDAO;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    public UserServiceImpl() {
        userDAO = UserDAO.getUserDAO();
    }

    @Override
    public void createUser(User user) {
        userDAO.create(user);
    }

    @Override
    public User getUserById(int id) {
        return userDAO.getById(id);
    }

    @Override
    public List<User> getAllUser() {
        return userDAO.getAll();
    }

    @Override
    public void updateUser(User user) {
        userDAO.update(user);
    }

    @Override
    public void deleteUserById(int id) {
        userDAO.deleteById(id);
    }

    @Override
    public void deleteUser(User user) {
        userDAO.delete(user);
    }

}
