package com.blog.by.kotor.service.userRole;

import com.blog.by.kotor.model.userRole.UserRole;

import java.util.List;

public interface UserRoleService {

    String getUserRole(Integer userId);

    void createUserRole(UserRole userRole);

    UserRole getUserRoleById(Integer id);

    List<UserRole> getAllUserRole();

    void updateUserRole(UserRole userRole);

    void deleteUserRoleById(Integer id);

    void deleteUserRole(UserRole userRole);

}
