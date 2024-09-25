package com.blog.by.kotor.role.service;

import com.blog.by.kotor.DAOException;
import com.blog.by.kotor.DBException;
import com.blog.by.kotor.UserRole;
import com.blog.by.kotor.user_role.UserRoleDAOImpl;

public class RoleServiceImpl implements RoleService {

    public RoleServiceImpl() {
    }

    @Override
    public void addUserRole(UserRole userRole) throws DAOException, DBException {
        UserRoleDAOImpl.getUserRoleDAOImpl().insert(userRole);
    }

}
