package com.blog.by.kotor.filter.service;

import com.blog.by.kotor.Category;
import com.blog.by.kotor.Filter;
import com.blog.by.kotor.Post;
import com.blog.by.kotor.Tag;
import com.blog.by.kotor.category.CategoryDAO;
import com.blog.by.kotor.category.CategoryDAOImpl;
import com.blog.by.kotor.filter.FilterDAO;
import com.blog.by.kotor.filter.FilterDAOImpl;
import com.blog.by.kotor.post_tag.PostTagDAO;
import com.blog.by.kotor.post_tag.PostTagDAOImpl;
import com.blog.by.kotor.tag.TagDAO;
import com.blog.by.kotor.tag.TagDAOImpl;

import java.util.ArrayList;
import java.util.List;

public class FilterService implements ImplFilterService {

    private List<Post> postList;

    private final FilterDAO filterDAO;

    private final TagDAO tagDAO;

    private final PostTagDAO postTagDAO;

    private final CategoryDAO categoryDAO;

    public FilterService(FilterDAOImpl filterDAOImpl, TagDAOImpl tagDAOImpl, PostTagDAOImpl postTagDAOImpl, CategoryDAOImpl categoryDAOImpl) {
        filterDAO = filterDAOImpl;
        tagDAO = tagDAOImpl;
        postTagDAO =  postTagDAOImpl;
        categoryDAO = categoryDAOImpl;
    }

    @Override
    public List<Post> findByTagCriteria(String criteria) {

        Filter filter = filterDAO.findByCriteria(criteria);

        Tag tag = tagDAO.findByName(filter.getName());

        postList = postTagDAO.findPostsByTagId(tag.getId());
        return postList;
    }

    @Override
    public List<Post> findByCategoryCriteria(String criteria) {

        Filter filter = filterDAO.findByCriteria(criteria);

        Category category = categoryDAO.findByName(filter.getName());

        postList = postTagDAO.findPostsByTagId(category.getId());
        return postList;
    }

}
