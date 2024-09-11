package com.blog.by.kotor.filter.service;

import com.blog.by.kotor.*;
import com.blog.by.kotor.PostCategory.PostCategory;
import com.blog.by.kotor.PostTag.PostTag;

import java.util.ArrayList;
import java.util.List;

public class FilterServiceImpl implements FilterService {

    private final FilterDAO filterDAO;

    private final TagDAO tagDAO;

    private final PostTagDAO postTagDAO;

    private final PostDAO postDAO;

    private final CategoryDAO categoryDAO;

    private final PostCategoryDAO postCategoryDAO;

    public FilterServiceImpl() {
        filterDAO = FilterDAO.getFilterDAO();
        tagDAO = TagDAO.getTagDAO();
        postTagDAO = PostTagDAO.getPostTagDAO();
        postDAO = PostDAO.getPostDAO();
        categoryDAO = CategoryDAO.getCategoryDAO();
        postCategoryDAO = PostCategoryDAO.getPostCategoryDAO();
    }

    @Override
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
    public void createFilter(Filter filter) {
        filterDAO.create(filter);
    }

    @Override
    public Filter getFilterById(int id) {
        return filterDAO.getById(id);
    }

    @Override
    public List<Filter> getAllFilter() {
        return filterDAO.getAll();
    }

    @Override
    public void updateFilter(Filter filter) {
        filterDAO.update(filter);
    }

    @Override
    public void deleteFilterById(int id) {
        filterDAO.deleteById(id);
    }

    @Override
    public void deleteFilter(Filter filter) {
        filterDAO.delete(filter);
    }

}
