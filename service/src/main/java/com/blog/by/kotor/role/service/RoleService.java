package com.blog.by.kotor.role.service;

import com.blog.by.kotor.UserRole.UserRole;
import com.blog.by.kotor.UserRoleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService implements ImplRoleService {

    private final UserRoleDAO userRoleDAO;

    @Autowired
    public RoleService(UserRoleDAO userRoleDAO) {
        this.userRoleDAO = userRoleDAO;
    }

    @Override
    public void addUserRole(UserRole userRole) {
        userRoleDAO.create(userRole);
    }

}
