package com.blog.by.kotor.service.tag;

import com.blog.by.kotor.dto.model.TagDTO;
import com.blog.by.kotor.model.Tag;

import java.util.List;

public interface TagService {

    void createTag(TagDTO tagDTO);

    Tag findTagByName(String tagName);

    Tag findTagById(Integer id);

    List<Tag> findAllTag();

    void updateTag(TagDTO tagDTO, Integer id);

    void deleteTagById(Integer id);

}
