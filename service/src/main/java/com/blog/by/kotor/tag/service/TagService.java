package com.blog.by.kotor.tag.service;

import com.blog.by.kotor.Tag;
import com.blog.by.kotor.tag.TagDAO;
import com.blog.by.kotor.tag.TagDAOImpl;

public class TagService implements ImplTagService {

    private final TagDAO tagDAO;

    public TagService() {
        tagDAO = new TagDAOImpl();
    }

    @Override
    public void createTag(Tag tag) {
        tagDAO.insert(tag);
    }

}
