package com.blog.by.kotor.userRole.service;

import com.blog.by.kotor.DAOException;
import com.blog.by.kotor.DBException;
import com.blog.by.kotor.Role;
import com.blog.by.kotor.UserRole;
import com.blog.by.kotor.role.RoleDAOImpl;
import com.blog.by.kotor.user_role.UserRoleDAOImpl;

public class UserRoleServiceImpl implements UserRoleService {

    public UserRoleServiceImpl() {
    }

    @Override
    public String getUserRole(int userId) throws DAOException, DBException {
        UserRole userRole = UserRoleDAOImpl.getUserRoleDAOImpl().findById(userId);

        Role role = RoleDAOImpl.getRoleDAOImpl().findById(userRole.getRoleId());
        return role.getName();
    }

}
