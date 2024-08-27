package com.blog.by.kotor;

public class RoleService {

    public void addUserRole(UserRole userRole) {
        UserRoleDAO userRoleDAO = new UserRoleDAO();
        userRoleDAO.create(userRole);
    }

}
