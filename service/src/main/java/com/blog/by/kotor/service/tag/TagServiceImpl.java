package com.blog.by.kotor.service.tag;

import com.blog.by.kotor.TagDTOMapper;
import com.blog.by.kotor.dto.model.TagDTO;
import com.blog.by.kotor.exception.ErrorCode;
import com.blog.by.kotor.exception.create.CreateException;
import com.blog.by.kotor.exception.delete.DeleteException;
import com.blog.by.kotor.exception.find.by.id.FindByIdException;
import com.blog.by.kotor.exception.find.by.name.FindByNameException;
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

    private final TagDTOMapper tagDTOMapper;

    @Override
    @Transactional
    public void createTag(TagDTO tagDTO) {
        if (tagDTO.getTagName() == null) {
            throw new CreateException(ErrorCode.TAG_NAME);
        }
        Tag tag = tagDTOMapper.toTag(tagDTO);
        tagRepository.save(tag);
    }

    @Override
    public Tag findTagByName(String tagName) {
        return tagRepository.findByName(tagName)
                .orElseThrow(() -> new FindByNameException(ErrorCode.TAG_NOT_FOUND, tagName));
    }

    @Override
    public Tag findTagById(Integer id) {
        return tagRepository.findById(id)
                .orElseThrow(() -> new FindByIdException(ErrorCode.TAG_NOT_FOUND, id));
    }

    @Override
    public List<Tag> findAllTag() {
        return tagRepository.findAll();
    }

    @Override
    @Transactional
    public void updateTag(TagDTO tagDTO, Integer id) {
        Tag tag = this.findTagById(id);
        tagRepository.save(tagDTOMapper.updateTag(tagDTO, tag));
    }

    @Override
    @Transactional
    public void deleteTagById(Integer id) {
        tagRepository.findById(id)
                .orElseThrow(() -> new DeleteException(ErrorCode.TAG_NOT_FOUND, id));
        tagRepository.deleteById(id);
    }

}
