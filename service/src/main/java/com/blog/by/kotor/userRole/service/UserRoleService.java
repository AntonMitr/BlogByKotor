package com.blog.by.kotor.userRole.service;

import com.blog.by.kotor.Role;
import com.blog.by.kotor.RoleDAO;
import com.blog.by.kotor.UserRole.UserRole;
import com.blog.by.kotor.UserRoleDAO;

public class UserRoleService implements ImplUserRoleService {

    private final UserRoleDAO userRoleDAO;

    private final RoleDAO roleDAO;

    public UserRoleService(UserRoleDAO userRoleDAO, RoleDAO roleDAO) {
        this.userRoleDAO = userRoleDAO;
        this.roleDAO = roleDAO;
    }

    @Override
    public String getUserRole(int userId) {
        UserRole userRole = userRoleDAO.findUserAndRoleByUserId(userId);

        Role role = roleDAO.getById(userRole.getUserRoleId().getUserId());
        return role.getName();
    }

}
