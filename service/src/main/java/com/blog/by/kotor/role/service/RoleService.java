package com.blog.by.kotor.role.service;

import com.blog.by.kotor.DAOException;
import com.blog.by.kotor.DBException;
import com.blog.by.kotor.UserRole;

public interface RoleService {

    void addUserRole(UserRole userRole) throws DAOException, DBException;

}
