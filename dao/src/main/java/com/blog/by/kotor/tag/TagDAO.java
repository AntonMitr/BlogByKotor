package com.blog.by.kotor.tag;

import com.blog.by.kotor.DAO;
import com.blog.by.kotor.DAOException;
import com.blog.by.kotor.DBException;
import com.blog.by.kotor.Tag;

public interface TagDAO extends DAO<Tag> {

    Tag findByName(String name) throws DAOException, DBException;

}
