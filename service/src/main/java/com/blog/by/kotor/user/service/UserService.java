package com.blog.by.kotor.user.service;

import com.blog.by.kotor.User;

import java.util.List;

public interface UserService {

    void createUser(User user);

    User getUserById(int id);

    List<User> getAllUser();

    void updateUser(User user);

    void deleteUserById(int id);

    void deleteUser(User user);
    
}
