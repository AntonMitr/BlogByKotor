package com.blog.by.kotor.service;

import com.blog.by.kotor.model.Option;

import java.util.List;

public interface OptionService {

    void createOption(Option option);

    Option getOptionById(int id);

    List<Option> getAllOption();

    void updateOption(Option option);

    void deleteOptionById(int id);

    void deleteOption(Option option);

}
