package com.blog.by.kotor.userRole.service;

import com.blog.by.kotor.Role;
import com.blog.by.kotor.UserRole;
import com.blog.by.kotor.role.RoleDAO;
import com.blog.by.kotor.role.RoleDAOImpl;
import com.blog.by.kotor.user_role.UserRoleDAO;
import com.blog.by.kotor.user_role.UserRoleDAOImpl;

public class UserRoleService implements ImplUserRoleService {

    private final RoleDAO roleDAO;

    private final UserRoleDAO userRoleDAO;

    public UserRoleService(RoleDAOImpl roleDAOImpl, UserRoleDAOImpl userRoleDAOImpl) {
        roleDAO = roleDAOImpl;
        userRoleDAO = userRoleDAOImpl;
    }

    @Override
    public String getUserRole(int userId) {
        UserRole userRole = userRoleDAO.findById(userId);

        Role role = roleDAO.findById(userRole.getRoleId());
        return role.getName();
    }

}
