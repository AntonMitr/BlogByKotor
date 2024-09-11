package com.blog.by.kotor.userRole.service;

import com.blog.by.kotor.DAOException;
import com.blog.by.kotor.DBException;

public interface UserRoleService {

    String getUserRole(int userId) throws DAOException, DBException;

}
