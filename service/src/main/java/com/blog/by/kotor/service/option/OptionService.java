package com.blog.by.kotor.service.option;

import com.blog.by.kotor.model.Option;

import java.util.List;

public interface OptionService {

    void createOption(Option option);

    Option getOptionById(Integer id);

    List<Option> getAllOption();

    void updateOption(Option option);

    void deleteOptionById(Integer id);

    void deleteOption(Option option);

}
