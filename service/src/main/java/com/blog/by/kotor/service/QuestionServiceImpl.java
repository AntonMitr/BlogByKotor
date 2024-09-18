package com.blog.by.kotor.service;

import com.blog.by.kotor.dao.QuestionDAO;
import com.blog.by.kotor.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionDAO questionDAO;

    @Autowired
    public QuestionServiceImpl(QuestionDAO questionDAO) {
        this.questionDAO = questionDAO;
    }

    @Override
    @Transactional
    public void createQuestion(Question question) {
        questionDAO.create(question);
    }

    @Override
    @Transactional
    public Question getQuestionById(Integer id) {
        return questionDAO.getById(id);
    }

    @Override
    @Transactional
    public List<Question> getAllQuestion() {
        return questionDAO.getAll();
    }

    @Override
    @Transactional
    public void updateQuestion(Question question) {
        questionDAO.update(question);
    }

    @Override
    @Transactional
    public void deleteQuestionById(Integer id) {
        questionDAO.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteQuestion(Question question) {
        questionDAO.delete(question);
    }

    @Override
    @Transactional
    public Question findByPollId(Integer pollId) {
        return questionDAO.findByPollId(pollId);
    }

}
