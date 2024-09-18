package com.blog.by.kotor.service;

import com.blog.by.kotor.model.Tag;
import com.blog.by.kotor.dao.TagDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    private final TagDAO tagDAO;

    @Autowired
    public TagServiceImpl(TagDAO tagDAO) {
        this.tagDAO = tagDAO;
    }

    @Override
    @Transactional
    public void createTag(Tag tag) {
        tagDAO.create(tag);
    }

    @Override
    @Transactional
    public Tag getTagById(Integer id) {
        return tagDAO.getById(id);
    }

    @Override
    @Transactional
    public List<Tag> getAllTag() {
        return tagDAO.getAll();
    }

    @Override
    @Transactional
    public void updateTag(Tag tag) {
        tagDAO.update(tag);
    }

    @Override
    @Transactional
    public void deleteTagById(Integer id) {
        tagDAO.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteTag(Tag tag) {
        tagDAO.delete(tag);
    }

}
