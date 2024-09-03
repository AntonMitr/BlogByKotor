package com.blog.by.kotor.role.service;

import com.blog.by.kotor.UserRole.UserRole;
import com.blog.by.kotor.UserRoleDAO;

public class RoleService implements ImplRoleService {

    private final UserRoleDAO userRoleDAO;

    public RoleService(UserRoleDAO userRoleDAO) {
        this.userRoleDAO = userRoleDAO;
    }

    @Override
    public void addUserRole(UserRole userRole) {
        userRoleDAO.create(userRole);
    }

}
