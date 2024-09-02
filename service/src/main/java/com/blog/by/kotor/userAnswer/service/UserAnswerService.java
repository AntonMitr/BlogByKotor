package com.blog.by.kotor.userAnswer.service;

import com.blog.by.kotor.UserAnswer;
import com.blog.by.kotor.UserAnswerDAO;

public class UserAnswerService implements ImplUserAnswerService {

    private final UserAnswerDAO userAnswerDAO;

    public UserAnswerService() {
        userAnswerDAO = new UserAnswerDAO();
    }

    @Override
    public void createUserAnswer(UserAnswer userAnswer) {
        userAnswerDAO.create(userAnswer);
    }

}
