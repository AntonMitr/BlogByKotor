package com.blog.by.kotor.user;

import com.blog.by.kotor.DAO;
import com.blog.by.kotor.User;

public interface UserDAO extends DAO<User> {

    boolean findByEmail(String email);

    boolean findByPassword(String password);

}
