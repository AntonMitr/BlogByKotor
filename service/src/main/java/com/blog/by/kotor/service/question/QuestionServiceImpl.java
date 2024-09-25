package com.blog.by.kotor.service.question;

import com.blog.by.kotor.exception.ErrorCode;
import com.blog.by.kotor.exception.delete.DeleteExceptionFactory;
import com.blog.by.kotor.exception.find.by.id.FindByIdExceptionFactory;
import com.blog.by.kotor.exception.update.UpdateExceptionFactory;
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
    @Transactional(readOnly = true)
    public Question findQuestionById(Integer id) {
        return questionRepository.findById(id).orElseThrow(() -> FindByIdExceptionFactory.moduleNotFound(ErrorCode.QUESTION_NOT_FOUND, id));

    }

    @Override
    public List<Question> findAllQuestion() {
        return questionRepository.findAll();
    }

    @Override
    public List<Question> findByQuestionTextContaining(String questionText) {
        return questionRepository.findByQuestionTextContaining(questionText);
    }

    @Override
    @Transactional
    public void updateQuestion(Question question) {
        questionRepository.findById(question.getId()).orElseThrow(() -> UpdateExceptionFactory.moduleNotFound(ErrorCode.QUESTION_NOT_FOUND, question.getId()));
        questionRepository.save(question);
    }

    @Override
    @Transactional
    public void deleteQuestionById(Integer id) {
        questionRepository.findById(id).orElseThrow(() -> DeleteExceptionFactory.moduleNotFound(ErrorCode.QUESTION_NOT_FOUND, id));
        questionRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteQuestion(Question question) {
        questionRepository.findById(question.getId()).orElseThrow(() -> DeleteExceptionFactory.moduleNotFound(ErrorCode.QUESTION_NOT_FOUND, question.getId()));
        questionRepository.delete(question);
    }

    @Override
    public Question findByPollId(Integer pollId) {
        return questionRepository.findByPollId(pollId);
    }

}
