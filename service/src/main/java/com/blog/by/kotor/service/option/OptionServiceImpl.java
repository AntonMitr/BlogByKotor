package com.blog.by.kotor.service.option;

import com.blog.by.kotor.model.Option;
import com.blog.by.kotor.repository.OptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OptionServiceImpl implements OptionService {

    private final OptionRepository optionRepository;

    @Override
    @Transactional
    public void createOption(Option option) {
        optionRepository.save(option);
    }

    @Override
    @Transactional
    public Option getOptionById(Integer id) {
        return optionRepository.getReferenceById(id);
    }

    @Override
    @Transactional
    public List<Option> getAllOption() {
        return optionRepository.findAll();
    }

    @Override
    @Transactional
    public void updateOption(Option option) {
        optionRepository.saveAndFlush(option);
    }

    @Override
    @Transactional
    public void deleteOptionById(Integer id) {
        optionRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteOption(Option option) {
        optionRepository.delete(option);
    }

}
