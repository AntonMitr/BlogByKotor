package com.blog.by.kotor.question.service;

import com.blog.by.kotor.Question;
import com.blog.by.kotor.question.QuestionDAO;
import com.blog.by.kotor.question.QuestionDAOImpl;

public class QuestionService implements ImplQuestionService {

    private final QuestionDAO questionDAO;

    public QuestionService(QuestionDAOImpl questionDAOImpl) {
        questionDAO = questionDAOImpl;
    }

    @Override
    public void createQuestion(Question question) {
        questionDAO.insert(question);
    }

}
