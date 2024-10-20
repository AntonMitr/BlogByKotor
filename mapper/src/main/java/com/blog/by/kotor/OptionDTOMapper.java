package com.blog.by.kotor;

import com.blog.by.kotor.dto.model.OptionDTO;
import com.blog.by.kotor.model.Option;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class OptionDTOMapper {

    public Option toOption(OptionDTO optionDTO) {
        return Option.builder()
                .optionText(optionDTO.getOptionText())
                .build();
    }

    public Option updateOption(OptionDTO optionDTO, Option option) {
        if (optionDTO.getOptionText() != null) {
            option.setOptionText(optionDTO.getOptionText());
        }
        return option;
    }

}
