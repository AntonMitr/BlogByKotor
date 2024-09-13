package com.blog.by.kotor.filter.service;

import com.blog.by.kotor.Filter;
import com.blog.by.kotor.Post;

import java.util.List;

public interface FilterService {

    List<Post> findByTagCriteria(String criteria);

    List<Post> findByCategoryCriteria(String criteria);

    void createFilter(Filter filter);

    Filter getFilterById(int id);

    List<Filter> getAllFilter();

    void updateFilter(Filter filter);

    void deleteFilterById(int id);

    void deleteFilter(Filter filter);

}
