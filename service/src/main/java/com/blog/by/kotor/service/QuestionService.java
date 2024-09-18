package com.blog.by.kotor.service;

import com.blog.by.kotor.model.Question;

import java.util.List;

public interface QuestionService {

    void createQuestion(Question question);

    Question getQuestionById(Integer id);

    List<Question> getAllQuestion();

    void updateQuestion(Question question);

    void deleteQuestionById(Integer id);

    void deleteQuestion(Question question);

    Question findByPollId(Integer pollId);

}
