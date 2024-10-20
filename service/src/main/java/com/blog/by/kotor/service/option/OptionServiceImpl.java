package com.blog.by.kotor.service.option;

import com.blog.by.kotor.OptionDTOMapper;
import com.blog.by.kotor.dto.model.OptionDTO;
import com.blog.by.kotor.exception.ErrorCode;
import com.blog.by.kotor.exception.create.CreateException;
import com.blog.by.kotor.exception.delete.DeleteException;
import com.blog.by.kotor.exception.find.by.id.FindByIdException;
import com.blog.by.kotor.model.Option;
import com.blog.by.kotor.repository.OptionRepository;
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

    private final OptionDTOMapper optionDTOMapper;

    @Override
    @Transactional
    public void createOption(OptionDTO optionDTO) {
        if (optionDTO.getOptionText() == null) {
            throw new CreateException(ErrorCode.OPTION_TEXT);
        }
        if (optionDTO.getQuestionId() == null) {
            throw new CreateException(ErrorCode.OPTION_QUESTION_ID);
        }

        Option option = optionDTOMapper.toOption(optionDTO);
        option.setQuestion(questionService.findQuestionById(optionDTO.getQuestionId()));
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
    public void updateOption(OptionDTO optionDTO, Integer id) {
        Option option = this.findOptionById(id);
        optionRepository.save(optionDTOMapper.updateOption(optionDTO, option));
    }

    @Override
    @Transactional
    public void deleteOptionById(Integer id) {
        optionRepository.findById(id)
                .orElseThrow(() -> new DeleteException(ErrorCode.OPTION_NOT_FOUND, id));
        optionRepository.deleteById(id);
    }

}
