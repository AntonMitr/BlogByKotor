package com.blog.by.kotor;

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

public class FilterService {

    public List<Post> findByTagCriteria(String criteria) {
        List<Post> postList = new ArrayList<>();

        FilterDAO filterDAO = new FilterDAOImpl();
        Filter filter = filterDAO.findByCriteria(criteria);

        TagDAO tagDAO = new TagDAOImpl();
        Tag tag = tagDAO.findByName(filter.getName());

        PostTagDAO postTagDAO = new PostTagDAOImpl();
        postList = postTagDAO.findPostsByTagId(tag.getId());
        return postList;
    }

    public List<Post> findByCategoryCriteria(String criteria) {
        List<Post> postList = new ArrayList<>();

        FilterDAO filterDAO = new FilterDAOImpl();
        Filter filter = filterDAO.findByCriteria(criteria);

        CategoryDAO categoryDAO = new CategoryDAOImpl();
        Category category = categoryDAO.findByName(filter.getName());

        PostTagDAO postTagDAO = new PostTagDAOImpl();
        postList = postTagDAO.findPostsByTagId(category.getId());
        return postList;
    }

}
