package com.blog.by.kotor.service.option;

import com.blog.by.kotor.exception.ErrorCode;
import com.blog.by.kotor.exception.NotNullParam;
import com.blog.by.kotor.exception.create.CreateExceptionFactory;
import com.blog.by.kotor.exception.delete.DeleteExceptionFactory;
import com.blog.by.kotor.exception.find.by.id.FindByIdExceptionFactory;
import com.blog.by.kotor.exception.update.UpdateExceptionFactory;
import com.blog.by.kotor.model.Option;
import com.blog.by.kotor.repository.OptionRepository;
import com.blog.by.kotor.repository.QuestionRepository;
import com.blog.by.kotor.service.question.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OptionServiceImpl implements OptionService {

    private final OptionRepository optionRepository;

    private final QuestionService questionService;

    @Override
    @Transactional
    public void createOption(Option option) {
        if(option.getId() == null){
            throw new CreateException(ErrorCode.OPTION_ID);
        }
        if(option.getOptionText() == null){
            throw new CreateException(ErrorCode.OPTION_TEXT);
        }
        if(option.getQuestion().getId() == null){
            throw new CreateException(ErrorCode.OPTION_QUESTION_ID);
        }
        optionRepository.save(option);
    }

    @Override
    public List<Option> findByQuestionId(Integer id) {
        questionService.findQuestionById(id);
        return optionRepository.findByQuestionId(id);
    }

    @Override
    public Option findOptionById(Integer id) {
        return optionRepository.findById(id)
                .orElseThrow(() -> new FindByIdException(ErrorCode.OPTION_NOT_FOUND, id));
    }

    @Override
    public List<Option> findAllOption() {
        return optionRepository.findAll();
    }

    @Override
    @Transactional
    public void updateOption(Option option) {
        optionRepository.findById(option.getId())
                .orElseThrow(() -> new UpdateException(ErrorCode.OPTION_NOT_FOUND, option.getId()));
        optionRepository.save(option);
    }

    @Override
    @Transactional
    public void deleteOptionById(Integer id) {
        optionRepository.findById(id)
                .orElseThrow(() -> new DeleteException(ErrorCode.OPTION_NOT_FOUND, id));
        optionRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteOption(Option option) {
        optionRepository.findById(option.getId())
                .orElseThrow(() -> new DeleteException(ErrorCode.OPTION_NOT_FOUND, option.getId()));
        optionRepository.delete(option);
    }

}
