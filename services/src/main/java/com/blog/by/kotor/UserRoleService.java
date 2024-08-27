package com.blog.by.kotor;

import com.blog.by.kotor.role.RoleDAO;
import com.blog.by.kotor.role.RoleDAOImpl;
import com.blog.by.kotor.user_role.UserRoleDAO;
import com.blog.by.kotor.user_role.UserRoleDAOImpl;

public class UserRoleService {

    public String getUserRole(int userId) {
        UserRoleDAO userRoleDAO = new UserRoleDAOImpl();
        UserRole userRole = userRoleDAO.findById(userId);

        RoleDAO roleDAO = new RoleDAOImpl();
        Role role = roleDAO.findById(userRole.getRoleId());
        return role.getName();
    }

}
