package com.blog.by.kotor.question.service;

import com.blog.by.kotor.Question;

import java.util.List;

public interface QuestionService {

    void createQuestion(Question question);

    Question getQuestionById(int id);

    List<Question> getAllQuestion();

    void updateQuestion(Question question);

    void deleteQuestionById(int id);

    void deleteQuestion(Question question);

    Question findByPollId(int pollId);

}
