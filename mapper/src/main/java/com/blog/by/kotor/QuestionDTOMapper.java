package com.blog.by.kotor;

import com.blog.by.kotor.dto.model.QuestionDTO;
import com.blog.by.kotor.model.Question;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class QuestionDTOMapper {

    public Question toQuestion(QuestionDTO questionDTO) {
        return Question.builder()
                .questionText(questionDTO.getQuestion())
                .build();
    }

    public Question update(QuestionDTO questionDTO, Question question) {
        if (questionDTO.getQuestion() != null) {
            question.setQuestionText(questionDTO.getQuestion());
        }
        return question;
    }

}
