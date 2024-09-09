package com.blog.by.kotor.tag.service;

import com.blog.by.kotor.Tag;
import com.blog.by.kotor.TagDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagService implements ImplTagService {

    private final TagDAO tagDAO;

    @Autowired
    public TagService(TagDAO tagDAO) {
        this.tagDAO = tagDAO;
    }

    @Override
    public void createTag(Tag tag) {
        tagDAO.create(tag);
    }

}
