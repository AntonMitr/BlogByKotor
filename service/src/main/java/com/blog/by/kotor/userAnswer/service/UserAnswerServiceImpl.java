package com.blog.by.kotor.userAnswer.service;

import com.blog.by.kotor.DAOException;
import com.blog.by.kotor.DBException;
import com.blog.by.kotor.UserAnswer;
import com.blog.by.kotor.user_answer.UserAnswerDAOImpl;

public class UserAnswerServiceImpl implements UserAnswerService {

    public UserAnswerServiceImpl() {
    }

    @Override
    public void createUserAnswer(UserAnswer userAnswer) throws DAOException, DBException {
        UserAnswerDAOImpl.getUserAnswerDAOImpl().insert(userAnswer);
    }

}
