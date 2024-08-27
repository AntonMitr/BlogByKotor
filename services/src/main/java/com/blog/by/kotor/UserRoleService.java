package com.blog.by.kotor;

import com.blog.by.kotor.UserRole.UserRole;

public class UserRoleService {

    public String getUserRole(int userId) {
        UserRoleDAO userRoleDAO = new UserRoleDAO();
        UserRole userRole = userRoleDAO.findUserAndRoleByUserId(userId);

        RoleDAO roleDAO = new RoleDAO();
        Role role = roleDAO.getById(userRole.getUserRoleId().getUserId());
        return role.getName();
    }

}
