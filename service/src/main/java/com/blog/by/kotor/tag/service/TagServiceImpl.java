package com.blog.by.kotor.tag.service;

import com.blog.by.kotor.DAOException;
import com.blog.by.kotor.DBException;
import com.blog.by.kotor.Tag;
import com.blog.by.kotor.tag.TagDAOImpl;

public class TagServiceImpl implements TagService {

    public TagServiceImpl() {
    }

    @Override
    public void createTag(Tag tag) throws DAOException, DBException {
        TagDAOImpl.getTagDAOImpl().insert(tag);
    }

}
