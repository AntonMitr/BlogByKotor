package com.blog.by.kotor.filter.service;

import com.blog.by.kotor.*;
import com.blog.by.kotor.PostCategory.PostCategory;
import com.blog.by.kotor.PostTag.PostTag;

import java.util.ArrayList;
import java.util.List;

public class FilterService implements ImplFilterService {

    private final FilterDAO filterDAO;

    private Filter filter;

    private final TagDAO tagDAO;

    private CategoryDAO categoryDAO;

    private final PostTagDAO postTagDAO;

    private final PostCategoryDAO postCategoryDAO;

    private final PostDAO postDAO;

    private List<Post> posts;

    private List<PostTag> postTagList;

    private List<PostCategory> postCategoryList;

    public FilterService() {
        filter = new Filter();
        filterDAO = new FilterDAO();
        tagDAO = new TagDAO();
        postTagDAO = new PostTagDAO();
        postDAO = new PostDAO();
        categoryDAO = new CategoryDAO();
        postCategoryDAO = new PostCategoryDAO();
    }

    @Override
    public List<Post> findByTagCriteria(String criteria) {
        posts = new ArrayList<>();
        postTagList = new ArrayList<>();

        filter = filterDAO.findByCriteria(criteria);

        Tag tag = tagDAO.findByName(filter.getName());

        postTagList = postTagDAO.findPostTagByTagId(tag.getId());
        for (PostTag postTag : postTagList) {
            posts.add(postDAO.getById(postTag.getId().getPostId()));
        }
        return posts;
    }

    @Override
    public List<Post> findByCategoryCriteria(String criteria) {
        posts = new ArrayList<>();
        postCategoryList = new ArrayList<>();

        filter = filterDAO.findByCriteria(criteria);

        Category category = categoryDAO.findByName(filter.getName());

        postCategoryList = postCategoryDAO.findPostsAndCategoriesByCategoryId(category.getId());
        for (PostCategory postCategory : postCategoryList) {
            posts.add(postDAO.getById(postCategory.getId().getCategoryId()));
        }
        return posts;
    }

}
