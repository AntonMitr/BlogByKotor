package com.blog.by.kotor.service.tag;

import com.blog.by.kotor.exception.ErrorCode;
import com.blog.by.kotor.exception.NotNullParam;
import com.blog.by.kotor.exception.create.CreateExceptionFactory;
import com.blog.by.kotor.exception.delete.DeleteExceptionFactory;
import com.blog.by.kotor.exception.find.by.id.FindByIdExceptionFactory;
import com.blog.by.kotor.exception.find.by.name.FindByNameExceptionFactory;
import com.blog.by.kotor.exception.update.UpdateExceptionFactory;
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
        if (tag.getId() == null) {
            throw CreateExceptionFactory.TagParamNotBeNull(NotNullParam.TAG_ID);
        }
        if (tag.getName() == null) {
            throw CreateExceptionFactory.TagParamNotBeNull(NotNullParam.TAG_NAME);
        }
        tagRepository.save(tag);
    }

    @Override
    public Tag findTagByName(String tagName) {
        return tagRepository.findByName(tagName).orElseThrow(() -> FindByNameExceptionFactory.moduleNotFound(ErrorCode.TAG_NOT_FOUND, tagName));
    }

    @Override
    public Tag findTagById(Integer id) {
        return tagRepository.findById(id).orElseThrow(() -> FindByIdExceptionFactory.moduleNotFound(ErrorCode.TAG_NOT_FOUND, id));
    }

    @Override
    public List<Tag> findAllTag() {
        return tagRepository.findAll();
    }

    @Override
    @Transactional
    public void updateTag(Tag tag) {
        tagRepository.findById(tag.getId()).orElseThrow(() -> UpdateExceptionFactory.moduleNotFound(ErrorCode.TAG_NOT_FOUND, tag.getId()));
        tagRepository.save(tag);
    }

    @Override
    @Transactional
    public void deleteTagById(Integer id) {
        tagRepository.findById(id).orElseThrow(() -> DeleteExceptionFactory.moduleNotFound(ErrorCode.TAG_NOT_FOUND, id));
        tagRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteTag(Tag tag) {
        tagRepository.findById(tag.getId()).orElseThrow(() -> DeleteExceptionFactory.moduleNotFound(ErrorCode.TAG_NOT_FOUND, tag.getId()));
        tagRepository.deleteById(tag.getId());
    }

}
