package com.blog.by.kotor;

import com.blog.by.kotor.tag.service.TagService;
import com.blog.by.kotor.tag.service.TagServiceImpl;

public class Main {

    public static void main(String[] args) {
        TagService tagService = new TagServiceImpl();
        Tag tag = new Tag();
        tag.setName("Tag valera");
        try {
            tagService.createTag(tag);
        } catch (DAOException | DBException ex) {
            ex.getMessage();
        }

    }
}
