package com.blog.by.kotor.tag.service;

import com.blog.by.kotor.Tag;
import com.blog.by.kotor.TagDAO;

import java.util.List;

public class TagServiceImpl implements TagService {

    private final TagDAO tagDAO;

    public TagServiceImpl() {
        tagDAO = TagDAO.getTagDAO();
    }

    @Override
    public void createTag(Tag tag) {
        tagDAO.create(tag);
    }

    @Override
    public Tag getTagById(int id) {
        return tagDAO.getById(id);
    }

    @Override
    public List<Tag> getAllTag() {
        return tagDAO.getAll();
    }

    @Override
    public void updateTag(Tag tag) {
        tagDAO.update(tag);
    }

    @Override
    public void deleteTagById(int id) {
        tagDAO.deleteById(id);
    }

    @Override
    public void deleteTag(Tag tag) {
        tagDAO.delete(tag);
    }

}
