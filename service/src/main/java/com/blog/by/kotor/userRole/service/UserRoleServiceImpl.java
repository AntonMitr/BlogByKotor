package com.blog.by.kotor.userRole.service;

import com.blog.by.kotor.Role;
import com.blog.by.kotor.RoleDAO;
import com.blog.by.kotor.User;
import com.blog.by.kotor.UserRole.UserRole;
import com.blog.by.kotor.UserRoleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleDAO userRoleDAO;

    private final RoleDAO roleDAO;

    @Autowired
    public UserRoleServiceImpl(UserRoleDAO userRoleDAO, RoleDAO roleDAO) {
        this.userRoleDAO = userRoleDAO;
        this.roleDAO = roleDAO;
    }

    @Override
    @Transactional
    public String getUserRole(int userId) {
        UserRole userRole = userRoleDAO.findUserAndRoleByUserId(userId);

        Role role = roleDAO.getById(userRole.getUserRoleId().getUserId());
        return role.getName();
    }

    @Override
    @Transactional
    public void createUserRole(UserRole userRole) {
        userRoleDAO.create(userRole);
    }

    @Override
    @Transactional
    public UserRole getUserRoleById(int id) {
        return userRoleDAO.findUserAndRoleByUserId(id);
    }

    @Override
    @Transactional
    public List<UserRole> getAllUserRole() {
        return userRoleDAO.getAll();
    }

    @Override
    @Transactional
    public void updateUserRole(UserRole userRole) {
        userRoleDAO.update(userRole);
    }

    @Override
    @Transactional
    public void deleteUserRoleById(int id) {
        userRoleDAO.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteUserRole(UserRole userRole) {
        userRoleDAO.delete(userRole);
    }

}
