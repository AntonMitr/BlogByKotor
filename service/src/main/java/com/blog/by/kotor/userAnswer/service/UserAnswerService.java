package com.blog.by.kotor.userAnswer.service;

import com.blog.by.kotor.UserAnswer;
import com.blog.by.kotor.user_answer.UserAnswerDAO;
import com.blog.by.kotor.user_answer.UserAnswerDAOImpl;

public class UserAnswerService implements ImplUserAnswerService {

    private final UserAnswerDAO userAnswerDAO;

    public UserAnswerService(UserAnswerDAOImpl userAnswerDAOImpl) {
        userAnswerDAO = userAnswerDAOImpl;
    }

    @Override
    public void createUserAnswer(UserAnswer userAnswer) {
        userAnswerDAO.insert(userAnswer);
    }

}
