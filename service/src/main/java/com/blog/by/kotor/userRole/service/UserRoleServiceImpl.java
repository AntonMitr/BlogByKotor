package com.blog.by.kotor.userRole.service;

import com.blog.by.kotor.Role;
import com.blog.by.kotor.RoleDAO;
import com.blog.by.kotor.userRole.UserRole;
import com.blog.by.kotor.UserRoleDAO;

import java.util.List;

public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleDAO userRoleDAO;

    private final RoleDAO roleDAO;

    public UserRoleServiceImpl() {
        userRoleDAO = UserRoleDAO.getUserRoleDAO();
        roleDAO = RoleDAO.getRoleDAO();
    }

    @Override
    public String getUserRole(int userId) {
        UserRole userRole = userRoleDAO.findUserAndRoleByUserId(userId);

        Role role = roleDAO.getById(userRole.getUserRoleId().getUserId());
        return role.getName();
    }

    @Override
    public void createUserRole(UserRole userRole) {
        userRoleDAO.create(userRole);
    }

    @Override
    public UserRole getUserRoleById(int id) {
        return userRoleDAO.findUserAndRoleByUserId(id);
    }

    @Override
    public List<UserRole> getAllUserRole() {
        return userRoleDAO.getAll();
    }

    @Override
    public void updateUserRole(UserRole userRole) {
        userRoleDAO.update(userRole);
    }

    @Override
    public void deleteUserRoleById(int id) {
        userRoleDAO.deleteById(id);
    }

    @Override
    public void deleteUserRole(UserRole userRole) {
        userRoleDAO.delete(userRole);
    }

}
