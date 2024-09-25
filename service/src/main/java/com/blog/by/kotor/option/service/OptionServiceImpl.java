package com.blog.by.kotor.option.service;

import com.blog.by.kotor.Option;
import com.blog.by.kotor.OptionDAO;

import java.util.List;

public class OptionServiceImpl implements OptionService {

    private final OptionDAO optionDAO;

    public OptionServiceImpl() {
        optionDAO = OptionDAO.getOptionDAO();
    }


    @Override
    public void createOption(Option option) {
        optionDAO.create(option);
    }

    @Override
    public Option getOptionById(int id) {
        return optionDAO.getById(id);
    }

    @Override
    public List<Option> getAllOption() {
        return optionDAO.getAll();
    }

    @Override
    public void updateOption(Option option) {
        optionDAO.update(option);
    }

    @Override
    public void deleteOptionById(int id) {
        optionDAO.deleteById(id);
    }

    @Override
    public void deleteOption(Option option) {
        optionDAO.delete(option);
    }

}
