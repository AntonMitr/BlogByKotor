package com.blog.by.kotor;

import com.blog.by.kotor.dto.model.CommentDTO;
import com.blog.by.kotor.model.Comment;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.function.Function;

@Service
public class CommentDTOMapper {

    public Comment toComment(CommentDTO commentDTO) {
        return Comment.builder()
                .content(commentDTO.getContent())
                .createdAt(LocalDate.now())
                .build();
    }

    public Comment updateComment(CommentDTO commentDTO, Comment comment) {
        if(commentDTO.getContent() != null) {
            comment.setContent(commentDTO.getContent());
        }
        return comment;
    }

}
