package com.blog.by.kotor;

public class QuestionService {

    public void createQuestion(Question question) {
        QuestionDAO questionDAO = new QuestionDAO();
        questionDAO.create(question);
    }

}
