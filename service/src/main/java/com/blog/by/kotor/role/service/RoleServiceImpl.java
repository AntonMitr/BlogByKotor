package com.blog.by.kotor.role.service;

import com.blog.by.kotor.Role;
import com.blog.by.kotor.RoleDAO;
import com.blog.by.kotor.UserRole.UserRole;
import com.blog.by.kotor.UserRoleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final UserRoleDAO userRoleDAO;

    private final RoleDAO roleDAO;

    @Autowired
    public RoleServiceImpl(UserRoleDAO userRoleDAO, RoleDAO roleDAO) {
        this.userRoleDAO = userRoleDAO;
        this.roleDAO = roleDAO;
    }

    @Override
    @Transactional
    public void createRole(Role role) {
        roleDAO.create(role);
    }

    @Override
    @Transactional
    public Role getRoleById(int id) {
        return roleDAO.getById(id);
    }

    @Override
    @Transactional
    public List<Role> getAllRole() {
        return roleDAO.getAll();
    }

    @Override
    @Transactional
    public void updateRole(Role role) {
        roleDAO.update(role);
    }

    @Override
    @Transactional
    public void deleteRoleById(int id) {
        roleDAO.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteRole(Role role) {
        roleDAO.delete(role);
    }

    @Override
    @Transactional
    public void addUserRole(UserRole userRole) {
        userRoleDAO.create(userRole);
    }

}
