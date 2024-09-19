package com.blog.by.kotor.service.tag;

import com.blog.by.kotor.model.Tag;

import java.util.List;

public interface TagService {

    void createTag(Tag tag);

    Tag getTagById(Integer id);

    List<Tag> getAllTag();

    void updateTag(Tag tag);

    void deleteTagById(Integer id);

    void deleteTag(Tag tag);

}
