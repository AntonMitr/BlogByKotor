package com.blog.by.kotor.question.service;

import com.blog.by.kotor.Question;
import com.blog.by.kotor.QuestionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

    private final QuestionDAO questionDAO;

    @Autowired
    public QuestionService(QuestionDAO questionDAO) {
        this.questionDAO = questionDAO;
    }

    public void createQuestion(Question question) {
        questionDAO.create(question);
    }

}
