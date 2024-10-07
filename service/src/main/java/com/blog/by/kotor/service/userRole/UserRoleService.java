package com.blog.by.kotor.service.userRole;

import com.blog.by.kotor.model.userRole.UserRole;

import java.util.List;

public interface UserRoleService {

    void createUserRole(UserRole userRole);

    UserRole findUserRoleByUserId(Integer id);

    List<UserRole> findAllUserRole();

    void updateUserRole(UserRole userRole);

    void deleteUserRole(UserRole userRole);

}
