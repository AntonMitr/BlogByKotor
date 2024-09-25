package com.blog.by.kotor.service;

import com.blog.by.kotor.model.user.role.UserRole;

import java.util.List;

public interface UserRoleService {

    String getUserRole(int userId);

    void createUserRole(UserRole userRole);

    UserRole getUserRoleById(int id);

    List<UserRole> getAllUserRole();

    void updateUserRole(UserRole userRole);

    void deleteUserRoleById(int id);

    void deleteUserRole(UserRole userRole);

}
