package com.blog.by.kotor;

public class UserAnswerService {

    public void createUserAnswer(UserAnswer userAnswer) {
        UserAnswerDAO userAnswerDAO = new UserAnswerDAO();
        userAnswerDAO.create(userAnswer);
    }

}
