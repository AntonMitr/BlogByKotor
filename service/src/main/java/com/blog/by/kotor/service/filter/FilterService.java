package com.blog.by.kotor.service.filter;

import com.blog.by.kotor.dto.model.FilterDTO;
import com.blog.by.kotor.model.Filter;
import com.blog.by.kotor.model.Post;

import java.util.List;

public interface FilterService {

    Filter findById(Integer id);

    Filter findByCriteria(String criteria);

    List<Post> findByTagCriteria(String criteria);

    List<Post> findByCategoryCriteria(String criteria);

    void createFilter(FilterDTO filterDTO);

    Filter findFilterById(Integer id);

    List<Filter> findAllFilter();

    void updateFilter(FilterDTO filterDTO, Integer id);

    void deleteFilterById(Integer id);

}
