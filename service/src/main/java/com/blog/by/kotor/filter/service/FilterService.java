package com.blog.by.kotor.filter.service;

import com.blog.by.kotor.*;
import com.blog.by.kotor.PostCategory.PostCategory;
import com.blog.by.kotor.PostTag.PostTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilterService implements ImplFilterService {

    private final FilterDAO filterDAO;

    private final CategoryDAO categoryDAO;

    private final PostDAO postDAO;

    @Autowired
    public FilterService(FilterDAO filterDAO, CategoryDAO categoryDAO, PostDAO postDAO) {
        this.filterDAO = filterDAO;
        this.categoryDAO = categoryDAO;
        this.postDAO = postDAO;
    }

    @Override
    public List<Post> findByTagCriteria(String criteria) {
        List<Post> posts = new ArrayList<>();
        List<PostTag> postTags;

        Filter filter = filterDAO.findByCriteria(criteria);

        TagDAO tagDAO = new TagDAO();

        Tag tag = tagDAO.findByName(filter.getName());

        PostTagDAO postTagDAO = new PostTagDAO();

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

        PostCategoryDAO postCategoryDAO = new PostCategoryDAO();

        postCategories = postCategoryDAO.findPostsAndCategoriesByCategoryId(category.getId());
        for (PostCategory postCategory : postCategories) {
            posts.add(postDAO.getById(postCategory.getId().getCategoryId()));
        }
        return posts;
    }

}
