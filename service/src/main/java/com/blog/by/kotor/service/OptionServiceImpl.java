package com.blog.by.kotor.service;

import com.blog.by.kotor.dao.OptionDAO;
import com.blog.by.kotor.model.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OptionServiceImpl implements OptionService {

    private final OptionDAO optionDAO;

    @Autowired
    public OptionServiceImpl(OptionDAO optionDAO) {
        this.optionDAO = optionDAO;
    }

    @Override
    @Transactional
    public void createOption(Option option) {
        optionDAO.create(option);
    }

    @Override
    @Transactional
    public Option getOptionById(int id) {
        return optionDAO.getById(id);
    }

    @Override
    @Transactional
    public List<Option> getAllOption() {
        return optionDAO.getAll();
    }

    @Override
    @Transactional
    public void updateOption(Option option) {
        optionDAO.update(option);
    }

    @Override
    @Transactional
    public void deleteOptionById(int id) {
        optionDAO.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteOption(Option option) {
        optionDAO.delete(option);
    }

}
