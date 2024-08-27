package com.blog.by.kotor;

import com.blog.by.kotor.tag.TagDAO;
import com.blog.by.kotor.tag.TagDAOImpl;

public class TagService {

    public void createTag(Tag tag) {
        TagDAO tagDAO = new TagDAOImpl();
        tagDAO.insert(tag);
    }

}
