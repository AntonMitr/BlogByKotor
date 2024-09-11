package com.blog.by.kotor.tag.service;

import com.blog.by.kotor.DAOException;
import com.blog.by.kotor.DBException;
import com.blog.by.kotor.Tag;

public interface TagService {

    void createTag(Tag tag) throws DAOException, DBException;

}
