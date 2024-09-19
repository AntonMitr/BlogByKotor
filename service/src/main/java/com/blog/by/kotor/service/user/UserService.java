package com.blog.by.kotor.service.user;

import com.blog.by.kotor.model.User;

import java.util.List;

public interface UserService {

    void createUser(User user);

    User getUserById(Integer id);

    List<User> getAllUser();

    void updateUser(User user);

    void deleteUserById(Integer id);

    void deleteUser(User user);

}
