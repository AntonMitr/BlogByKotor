package com.blog.by.kotor.service.question;

import com.blog.by.kotor.model.Question;
import com.blog.by.kotor.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    @Override
    @Transactional
    public void createQuestion(Question question) {
        questionRepository.save(question);
    }

    @Override
    @Transactional
    public Question getQuestionById(Integer id) {
        return questionRepository.getReferenceById(id);
    }

    @Override
    @Transactional
    public List<Question> getAllQuestion() {
        return questionRepository.findAll();
    }

    @Override
    @Transactional
    public void updateQuestion(Question question) {
        questionRepository.saveAndFlush(question);
    }

    @Override
    @Transactional
    public void deleteQuestionById(Integer id) {
        questionRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteQuestion(Question question) {
        questionRepository.delete(question);
    }

    @Override
    @Transactional
    public Question findByPollId(Integer pollId) {
        return questionRepository.findByPollId(pollId);
    }

}
