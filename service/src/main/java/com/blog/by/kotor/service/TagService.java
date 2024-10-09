package com.blog.by.kotor.service;

import com.blog.by.kotor.model.Tag;

import java.util.List;

public interface TagService {

    void createTag(Tag tag);

    Tag getTagById(int id);

    List<Tag> getAllTag();

    void updateTag(Tag tag);

    void deleteTagById(int id);

    void deleteTag(Tag tag);

}
