package com.blog.by.kotor.service.question;

import com.blog.by.kotor.QuestionDTOMapper;
import com.blog.by.kotor.dto.model.QuestionDTO;
import com.blog.by.kotor.exception.ErrorCode;
import com.blog.by.kotor.exception.create.CreateException;
import com.blog.by.kotor.exception.find.by.id.FindByIdException;
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

    private final QuestionDTOMapper questionDTOMapper;

    @Override
    @Transactional
    public void createQuestion(QuestionDTO questionDTO) {
        if (questionDTO.getPollId() == null) {
            throw new CreateException(ErrorCode.QUESTION_POLL_ID);
        }
        if (questionDTO.getQuestion() == null) {
            throw new CreateException(ErrorCode.QUESTION_TEXT);
        }

        Question question = questionDTOMapper.toQuestion(questionDTO);
        question.setPoll(pollService.findPollById(questionDTO.getPollId()));
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
    public void updateQuestion(QuestionDTO questionDTO, Integer id) {
        Question question = this.findQuestionById(id);
        questionRepository.save(questionDTOMapper.update(questionDTO, question));
    }

    @Override
    @Transactional
    public void deleteQuestionById(Integer id) {
        this.findQuestionById(id);
        questionRepository.deleteById(id);
    }

    @Override
    public Question findByPollId(Integer pollId) {
        return questionRepository.findByPollId(pollId).orElseThrow(() -> new FindByIdException(ErrorCode.POLL_NOT_FOUND, pollId));
    }

}
