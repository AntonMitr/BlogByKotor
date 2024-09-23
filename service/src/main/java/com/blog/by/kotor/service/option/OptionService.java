package com.blog.by.kotor.service.option;

import com.blog.by.kotor.model.Option;

import java.util.List;

public interface OptionService {

    void createOption(Option option);

    List<Option> findByQuestionId(Integer id);

    Option findOptionById(Integer id);

    List<Option> findAllOption();

    void updateOption(Option option);

    void deleteOptionById(Integer id);

    void deleteOption(Option option);

}
