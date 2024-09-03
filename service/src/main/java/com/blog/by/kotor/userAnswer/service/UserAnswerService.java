package com.blog.by.kotor.userAnswer.service;

import com.blog.by.kotor.UserAnswer;
import com.blog.by.kotor.UserAnswerDAO;

public class UserAnswerService implements ImplUserAnswerService {

    private final UserAnswerDAO userAnswerDAO;

    public UserAnswerService(UserAnswerDAO userAnswerDAO) {
        this.userAnswerDAO = userAnswerDAO;
    }

    @Override
    public void createUserAnswer(UserAnswer userAnswer) {
        userAnswerDAO.create(userAnswer);
    }

}
