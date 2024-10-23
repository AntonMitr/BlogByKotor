package com.blog.by.kotor.service.question;

import com.blog.by.kotor.exception.ErrorCode;
import com.blog.by.kotor.exception.create.CreateException;
import com.blog.by.kotor.exception.delete.DeleteException;
import com.blog.by.kotor.exception.find.by.id.FindByIdException;
import com.blog.by.kotor.exception.update.UpdateException;
import com.blog.by.kotor.model.Question;
import com.blog.by.kotor.repository.QuestionRepository;
import com.blog.by.kotor.service.poll.PollService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    private final PollService pollService;

    @Override
    @Transactional
    public void createQuestion(Question question) {
        if (question.getId() == null) {
            throw new CreateException(ErrorCode.QUESTION_ID);
        }
        if (question.getPoll().getId() == null) {
            throw new CreateException(ErrorCode.QUESTION_POLL_ID);
        }
        if (question.getQuestionText() == null) {
            throw new CreateException(ErrorCode.QUESTION_TEXT);
        }
        questionRepository.save(question);
    }

    @Override
    public Question findQuestionById(Integer id) {
        return questionRepository.findById(id)
                .orElseThrow(() -> new FindByIdException(ErrorCode.QUESTION_NOT_FOUND, id));

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
        questionRepository.findById(question.getId())
                .orElseThrow(() -> new UpdateException(ErrorCode.QUESTION_NOT_FOUND, question.getId()));
        questionRepository.save(question);
    }

    @Override
    @Transactional
    public void deleteQuestionById(Integer id) {
        questionRepository.findById(id)
                .orElseThrow(() -> new DeleteException(ErrorCode.QUESTION_NOT_FOUND, id));
        questionRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteQuestion(Question question) {
        questionRepository.findById(question.getId())
                .orElseThrow(() -> new DeleteException(ErrorCode.QUESTION_NOT_FOUND, question.getId()));
        questionRepository.delete(question);
    }

    @Override
    public Question findByPollId(Integer pollId) {
        pollService.findPollById(pollId);
        return questionRepository.findByPollId(pollId);
    }

}
