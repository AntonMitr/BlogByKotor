package com.blog.by.kotor.user;

import com.blog.by.kotor.DAO;
import com.blog.by.kotor.DAOException;
import com.blog.by.kotor.DBException;
import com.blog.by.kotor.User;

public interface UserDAO extends DAO<User> {

    boolean findByEmail(String email) throws DAOException, DBException;

    boolean findByPassword(String password) throws DAOException, DBException;

}
