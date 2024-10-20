package com.blog.by.kotor;

import com.blog.by.kotor.dto.model.PostDTO;
import com.blog.by.kotor.model.Post;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.function.Function;

@Service
public class PostDTOMapper {

    public Post toPost(PostDTO postDTO) {
        return Post.builder()
                .isPremium(postDTO.isPremium())
                .isPublished(postDTO.isPublished())
                .content(postDTO.getContent())
                .title(postDTO.getTitle())
                .datePublished(LocalDate.now())
                .build();
    }

    public Post updatePost(PostDTO postDTO, Post post) {
        if (postDTO.getContent() != null) {
            post.setContent(postDTO.getContent());
        }
        if (postDTO.getTitle() != null) {
            post.setTitle(postDTO.getTitle());
        }
        return post;
    }

}
