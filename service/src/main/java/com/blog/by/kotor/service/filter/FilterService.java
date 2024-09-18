package com.blog.by.kotor.service.filter;

import com.blog.by.kotor.model.Filter;
import com.blog.by.kotor.model.Post;

import java.util.List;

public interface FilterService {

    List<Post> findByTagCriteria(String criteria);

    List<Post> findByCategoryCriteria(String criteria);

    void createFilter(Filter filter);

    Filter getFilterById(Integer id);

    List<Filter> getAllFilter();

    void updateFilter(Filter filter);

    void deleteFilterById(Integer id);

    void deleteFilter(Filter filter);

}
