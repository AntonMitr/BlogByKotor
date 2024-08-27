package com.blog.by.kotor;

import com.blog.by.kotor.user_role.UserRoleDAO;
import com.blog.by.kotor.user_role.UserRoleDAOImpl;

public class RoleService {

    public void addUserRole(UserRole userRole) {
        UserRoleDAO userRoleDAO = new UserRoleDAOImpl();
        userRoleDAO.insert(userRole);
    }

}
