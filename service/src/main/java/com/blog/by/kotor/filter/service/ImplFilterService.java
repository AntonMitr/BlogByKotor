package com.blog.by.kotor.filter.service;

import com.blog.by.kotor.Post;

import java.util.List;

public interface ImplFilterService {

    List<Post> findByTagCriteria(String criteria);

    List<Post> findByCategoryCriteria(String criteria);

}
