package com.blog.by.kotor.role.service;

import com.blog.by.kotor.UserRole;
import com.blog.by.kotor.user_role.UserRoleDAO;
import com.blog.by.kotor.user_role.UserRoleDAOImpl;

public class RoleService implements ImplRoleService {

    private final UserRoleDAO userRoleDAO;

    public RoleService(UserRoleDAOImpl userRoleDAOImpl) {
        userRoleDAO = userRoleDAOImpl;
    }

    @Override
    public void addUserRole(UserRole userRole) {
        userRoleDAO.insert(userRole);
    }

}
