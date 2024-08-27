package com.blog.by.kotor;

import com.blog.by.kotor.UserRole.UserRole;

public class RoleService {

    public void addUserRole(UserRole userRole) {
        UserRoleDAO userRoleDAO = new UserRoleDAO();
        userRoleDAO.create(userRole);
    }

}
