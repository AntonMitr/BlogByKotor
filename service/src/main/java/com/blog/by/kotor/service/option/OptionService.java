package com.blog.by.kotor.service.option;

import com.blog.by.kotor.dto.model.OptionDTO;
import com.blog.by.kotor.model.Option;

import java.util.List;

public interface OptionService {

    void createOption(OptionDTO optionDTO);

    List<Option> findByQuestionId(Integer id);

    Option findOptionById(Integer id);

    List<Option> findAllOption();

    void updateOption(OptionDTO optionDTO, Integer id);

    void deleteOptionById(Integer id);

}
