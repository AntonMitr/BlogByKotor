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
    @Transactional(readOnly = true)
    public Tag findTagByName(String tagName) {
        return tagRepository.findByName(tagName);
    }

    @Override
    @Transactional(readOnly = true)
    public Tag findTagById(Integer id) {
        return tagRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Tag> findAllTag() {
        return tagRepository.findAll();
    }

    @Override
    @Transactional
    public void updateTag(Tag tag) {
        tagRepository.save(tag);
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
