package com.blog.by.kotor.service.tag;

import com.blog.by.kotor.model.Tag;
import com.blog.by.kotor.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    @Override
    @Transactional
    public void createTag(Tag tag) {
        tagRepository.save(tag);
    }

    @Override
    @Transactional
    public Tag getTagById(Integer id) {
        return tagRepository.getReferenceById(id);
    }

    @Override
    @Transactional
    public List<Tag> getAllTag() {
        return tagRepository.findAll();
    }

    @Override
    @Transactional
    public void updateTag(Tag tag) {
        tagRepository.saveAndFlush(tag);
    }

    @Override
    @Transactional
    public void deleteTagById(Integer id) {
        tagRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteTag(Tag tag) {
        tagRepository.delete(tag);
    }

}
