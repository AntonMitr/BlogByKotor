package com.blog.by.kotor.service.user;

import com.blog.by.kotor.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService {

    void createUser(User user);

    User findUserById(Integer id);

    List<User> findAllUser();

    void updateUser(User user);

    void deleteUserById(Integer id);

    void deleteUser(User user);

}
