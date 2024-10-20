package com.blog.by.kotor.service.question;

import com.blog.by.kotor.dto.model.QuestionDTO;
import com.blog.by.kotor.model.Question;

import java.util.List;

public interface QuestionService {

    void createQuestion(QuestionDTO questionDTO);

    Question findQuestionById(Integer id);

    List<Question> findAllQuestion();

    List<Question> findByQuestionTextContaining(String questionText);

    void updateQuestion(QuestionDTO questionDTO, Integer id);

    void deleteQuestionById(Integer id);

    Question findByPollId(Integer pollId);

}
