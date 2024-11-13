package com.blog.by.kotor.service.user;

import com.blog.by.kotor.dto.authentication.RegistrationDTO;
import com.blog.by.kotor.dto.model.UserDTO;
import com.blog.by.kotor.model.User;

import java.util.List;

public interface UserService {

    void createUser(RegistrationDTO registrationDTO);

    User findByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    User findUserById(Integer id);

    List<User> findAllUser();

    void updateUser(UserDTO userDTO, Integer id);

    void deleteUserById(Integer id);

}
