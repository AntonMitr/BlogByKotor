package com.blog.by.kotor.question.service;

import com.blog.by.kotor.DAOException;
import com.blog.by.kotor.DBException;
import com.blog.by.kotor.Question;
import com.blog.by.kotor.question.QuestionDAOImpl;

public class QuestionServiceImpl implements QuestionService {

    public QuestionServiceImpl() {
    }

    @Override
    public void createQuestion(Question question) throws DAOException, DBException {
        QuestionDAOImpl.getQuestionDAOImpl().insert(question);
    }

}
