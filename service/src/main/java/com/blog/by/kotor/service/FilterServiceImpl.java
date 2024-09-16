package com.blog.by.kotor.service;

import com.blog.by.kotor.dao.*;
import com.blog.by.kotor.model.Category;
import com.blog.by.kotor.model.Filter;
import com.blog.by.kotor.model.Post;
import com.blog.by.kotor.model.postCategory.PostCategory;
import com.blog.by.kotor.model.postTag.PostTag;
import com.blog.by.kotor.model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilterServiceImpl implements FilterService {

    private final FilterDAO filterDAO;

    private final TagDAO tagDAO;

    private final PostTagDAO postTagDAO;

    private final PostDAO postDAO;

    private final CategoryDAO categoryDAO;

    private final PostCategoryDAO postCategoryDAO;

    @Autowired
    public FilterServiceImpl(FilterDAO filterDAO, TagDAO tagDAO, PostTagDAO postTagDAO, PostDAO postDAO, CategoryDAO categoryDAO, PostCategoryDAO postCategoryDAO) {
        this.filterDAO = filterDAO;
        this.tagDAO = tagDAO;
        this.postTagDAO = postTagDAO;
        this.postDAO = postDAO;
        this.categoryDAO = categoryDAO;
        this.postCategoryDAO = postCategoryDAO;
    }

    @Override
    @Transactional
    public List<Post> findByTagCriteria(String criteria) {
        List<Post> posts = new ArrayList<>();
        List<PostTag> postTags;

        Filter filter = filterDAO.findByCriteria(criteria);

        Tag tag = tagDAO.findByName(filter.getName());

        postTags = postTagDAO.findPostTagByTagId(tag.getId());
        for (PostTag postTag : postTags) {
            posts.add(postDAO.getById(postTag.getId().getPostId()));
        }
        return posts;
    }

    @Override
    @Transactional
    public List<Post> findByCategoryCriteria(String criteria) {
        List<Post> posts = new ArrayList<>();
        List<PostCategory> postCategories;

        Filter filter = filterDAO.findByCriteria(criteria);

        Category category = categoryDAO.findByName(filter.getName());

        postCategories = postCategoryDAO.findPostsAndCategoriesByCategoryId(category.getId());
        for (PostCategory postCategory : postCategories) {
            posts.add(postDAO.getById(postCategory.getId().getCategoryId()));
        }
        return posts;
    }

    @Override
    @Transactional
    public void createFilter(Filter filter) {
        filterDAO.create(filter);
    }

    @Override
    @Transactional
    public Filter getFilterById(int id) {
        return filterDAO.getById(id);
    }

    @Override
    @Transactional
    public List<Filter> getAllFilter() {
        return filterDAO.getAll();
    }

    @Override
    @Transactional
    public void updateFilter(Filter filter) {
        filterDAO.update(filter);
    }

    @Override
    @Transactional
    public void deleteFilterById(int id) {
        filterDAO.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteFilter(Filter filter) {
        filterDAO.delete(filter);
    }

}
