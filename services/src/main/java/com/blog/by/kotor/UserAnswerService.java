package com.blog.by.kotor;

import com.blog.by.kotor.user_answer.UserAnswerDAO;
import com.blog.by.kotor.user_answer.UserAnswerDAOImpl;

public class UserAnswerService {

    public void createUserAnswer(UserAnswer userAnswer) {
        UserAnswerDAO userAnswerDAO = new UserAnswerDAOImpl();
        userAnswerDAO.insert(userAnswer);
    }

}
