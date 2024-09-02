package com.blog.by.kotor.tag.service;

import com.blog.by.kotor.Tag;
import com.blog.by.kotor.TagDAO;

public class TagService implements ImplTagService {

    private final TagDAO tagDAO;

    public TagService() {
        tagDAO = new TagDAO();
    }

    @Override
    public void createTag(Tag tag) {
        tagDAO.create(tag);
    }

}
