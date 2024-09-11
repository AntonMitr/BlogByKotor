package com.blog.by.kotor.userAnswer.service;

import com.blog.by.kotor.DAOException;
import com.blog.by.kotor.DBException;
import com.blog.by.kotor.UserAnswer;

public interface UserAnswerService {

    void createUserAnswer(UserAnswer userAnswer) throws DAOException, DBException;

}
