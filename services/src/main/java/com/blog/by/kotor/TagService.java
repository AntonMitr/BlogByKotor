package com.blog.by.kotor;

public class TagService {

    public void createTag(Tag tag) {
        TagDAO tagDAO = new TagDAO();
        tagDAO.create(tag);
    }

}
