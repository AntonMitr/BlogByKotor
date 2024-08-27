package com.blog.by.kotor;

import com.blog.by.kotor.question.QuestionDAO;
import com.blog.by.kotor.question.QuestionDAOImpl;

public class QuestionService {

    public void createQuestion(Question question) {
        QuestionDAO questionDAO = new QuestionDAOImpl();
        questionDAO.insert(question);
    }

}
