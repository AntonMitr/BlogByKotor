package com.blog.by.kotor;

public class UserRoleService {

    public String getUserRole(int userId) {
        UserRoleDAO userRoleDAO = new UserRoleDAO();
        UserRole userRole = userRoleDAO.findUserAndRoleByUserId(userId);

        RoleDAO roleDAO = new RoleDAO();
        Role role = roleDAO.getById(userRole.getRoleId());
        return role.getName();
    }

}
