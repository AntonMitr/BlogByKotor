package com.blog.by.kotor.userAnswer.service;

import com.blog.by.kotor.UserAnswer;
import com.blog.by.kotor.UserAnswerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAnswerService implements ImplUserAnswerService {

    private final UserAnswerDAO userAnswerDAO;

    @Autowired
    public UserAnswerService(UserAnswerDAO userAnswerDAO) {
        this.userAnswerDAO = userAnswerDAO;
    }

    @Override
    public void createUserAnswer(UserAnswer userAnswer) {
        userAnswerDAO.create(userAnswer);
    }

}
