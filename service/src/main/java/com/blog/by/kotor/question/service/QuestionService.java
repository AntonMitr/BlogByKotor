package com.blog.by.kotor.question.service;

import com.blog.by.kotor.Question;
import com.blog.by.kotor.QuestionDAO;

public class QuestionService {

    private QuestionDAO questionDAO;

    public QuestionService() {
        questionDAO = new QuestionDAO();
    }

    public void createQuestion(Question question) {
        questionDAO.create(question);
    }

}
