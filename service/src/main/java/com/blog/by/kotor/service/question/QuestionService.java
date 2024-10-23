package com.blog.by.kotor.service.question;

import com.blog.by.kotor.model.Question;

import java.util.List;

public interface QuestionService {

    void createQuestion(Question question);

    Question findQuestionById(Integer id);

    List<Question> findAllQuestion();

    List<Question> findByQuestionTextContaining(String questionText);

    void updateQuestion(Question question);

    void deleteQuestionById(Integer id);

    void deleteQuestion(Question question);

    Question findByPollId(Integer pollId);

}
