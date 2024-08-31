package com.blog.by.kotor.question.service;

import com.blog.by.kotor.Question;
import com.blog.by.kotor.question.QuestionDAO;
import com.blog.by.kotor.question.QuestionDAOImpl;

public class QuestionService implements ImplQuestionService {

    private final QuestionDAO questionDAO;

    public QuestionService() {
        questionDAO = new QuestionDAOImpl();
    }

    @Override
    public void createQuestion(Question question) {
        questionDAO.insert(question);
    }

}
