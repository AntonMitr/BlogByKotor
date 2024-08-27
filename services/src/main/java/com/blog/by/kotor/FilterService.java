package com.blog.by.kotor;

import com.blog.by.kotor.PostCategory.PostCategory;
import com.blog.by.kotor.PostTag.PostTag;

import java.util.ArrayList;
import java.util.List;

public class FilterService {

    public List<Post> findByTagCriteria(String criteria) {
        List<Post> posts = new ArrayList<>();
        List<PostTag> postAndTagList;

        FilterDAO filterDAO = new FilterDAO();
        Filter filter = filterDAO.findByCriteria(criteria);

        TagDAO tagDAO = new TagDAO();
        Tag tag = tagDAO.findByName(filter.getName());

        PostTagDAO postTagDAO = new PostTagDAO();
        postAndTagList = postTagDAO.findPostTagByTagId(tag.getId());
        for (PostTag postTag : postAndTagList) {
            PostDAO postDAO = new PostDAO();
            posts.add(postDAO.getById(postTag.getId().getPostId()));
        }
        return posts;
    }

    public List<Post> findByCategoryCriteria(String criteria) {
        List<Post> posts = new ArrayList<>();
        List<PostCategory> postAndCategoryList;

        FilterDAO filterDAO = new FilterDAO();
        Filter filter = filterDAO.findByCriteria(criteria);

        CategoryDAO categoryDAO = new CategoryDAO();
        Category category = categoryDAO.findByName(filter.getName());

        PostCategoryDAO postCategoryDAO = new PostCategoryDAO();
        postAndCategoryList = postCategoryDAO.findPostsAndCategoriesByCategoryId(category.getId());
        for (PostCategory postCategory : postAndCategoryList) {
            PostDAO postDAO = new PostDAO();
            posts.add(postDAO.getById(postCategory.getId().getCategoryId()));
        }
        return posts;
    }

}
