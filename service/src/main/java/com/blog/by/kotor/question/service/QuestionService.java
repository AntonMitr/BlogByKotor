package com.blog.by.kotor.question.service;

import com.blog.by.kotor.DAOException;
import com.blog.by.kotor.DBException;
import com.blog.by.kotor.Question;

public interface QuestionService {

    void createQuestion(Question question) throws DAOException, DBException;

}
