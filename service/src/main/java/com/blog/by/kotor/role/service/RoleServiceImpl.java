package com.blog.by.kotor.role.service;

import com.blog.by.kotor.Role;
import com.blog.by.kotor.RoleDAO;
import com.blog.by.kotor.UserRole.UserRole;
import com.blog.by.kotor.UserRoleDAO;

import java.util.List;

public class RoleServiceImpl implements RoleService {

    private final UserRoleDAO userRoleDAO;

    private final RoleDAO roleDAO;

    public RoleServiceImpl() {
        userRoleDAO = UserRoleDAO.getUserRoleDAO();
        roleDAO = RoleDAO.getRoleDAO();
    }

    @Override
    public void createRole(Role role) {
        roleDAO.create(role);
    }

    @Override
    public Role getRoleById(int id) {
        return roleDAO.getById(id);
    }

    @Override
    public List<Role> getAllRole() {
        return roleDAO.getAll();
    }

    @Override
    public void updateRole(Role role) {
        roleDAO.update(role);
    }

    @Override
    public void deleteRoleById(int id) {
        roleDAO.deleteById(id);
    }

    @Override
    public void deleteRole(Role role) {
        roleDAO.delete(role);
    }

    @Override
    public void addUserRole(UserRole userRole) {
        userRoleDAO.create(userRole);
    }

}
