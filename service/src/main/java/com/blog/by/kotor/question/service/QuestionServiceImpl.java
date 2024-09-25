package com.blog.by.kotor.question.service;

import com.blog.by.kotor.Question;
import com.blog.by.kotor.QuestionDAO;

import java.util.List;

public class QuestionServiceImpl implements QuestionService {

    private final QuestionDAO questionDAO;

    public QuestionServiceImpl() {
        questionDAO = QuestionDAO.getQuestionDAO();
    }

    @Override
    public void createQuestion(Question question) {
        questionDAO.create(question);
    }

    @Override
    public Question getQuestionById(int id) {
        return questionDAO.getById(id);
    }

    @Override
    public List<Question> getAllQuestion() {
        return questionDAO.getAll();
    }

    @Override
    public void updateQuestion(Question question) {
        questionDAO.update(question);
    }

    @Override
    public void deleteQuestionById(int id) {
        questionDAO.deleteById(id);
    }

    @Override
    public void deleteQuestion(Question question) {
        questionDAO.delete(question);
    }

    @Override
    public Question findByPollId(int pollId) {
        return questionDAO.findByPollId(pollId);
    }

}
