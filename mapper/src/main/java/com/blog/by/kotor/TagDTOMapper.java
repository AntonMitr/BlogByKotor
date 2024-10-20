package com.blog.by.kotor;

import com.blog.by.kotor.dto.model.TagDTO;
import com.blog.by.kotor.model.Tag;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class TagDTOMapper {

    public Tag toTag(TagDTO tagDTO) {
        return Tag.builder()
                .name(tagDTO.getTagName())
                .build();
    }

    public Tag updateTag(TagDTO tagDTO, Tag tag) {
        if (tagDTO.getTagName() != null) {
            tag.setName(tagDTO.getTagName());
        }
        return tag;
    }

}
