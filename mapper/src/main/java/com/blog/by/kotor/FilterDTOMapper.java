package com.blog.by.kotor;

import com.blog.by.kotor.dto.model.FilterDTO;
import com.blog.by.kotor.model.Filter;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class FilterDTOMapper {

    public Filter toFilter(FilterDTO filterDTO) {
        return Filter.builder()
                .criteria(filterDTO.getCriteria())
                .name(filterDTO.getName())
                .build();
    }

    public Filter updateFilter(FilterDTO filterDTO, Filter filter) {
        if(filterDTO.getCriteria() != null) {
            filter.setCriteria(filterDTO.getCriteria());
        }
        if(filterDTO.getName() != null) {
            filter.setName(filterDTO.getName());
        }
        return filter;
    }

}
