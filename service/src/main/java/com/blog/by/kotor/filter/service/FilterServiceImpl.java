package com.blog.by.kotor.filter.service;

import com.blog.by.kotor.*;
import com.blog.by.kotor.category.CategoryDAOImpl;
import com.blog.by.kotor.filter.FilterDAOImpl;
import com.blog.by.kotor.post_tag.PostTagDAOImpl;
import com.blog.by.kotor.tag.TagDAOImpl;

import java.util.List;

public class FilterServiceImpl implements FilterService {

    public FilterServiceImpl() {
    }

    @Override
    public List<Post> findByTagCriteria(String criteria) throws DAOException, DBException {

        Filter filter = FilterDAOImpl.getFilterDAOImpl().findByCriteria(criteria);

        Tag tag = TagDAOImpl.getTagDAOImpl().findByName(filter.getName());

        return PostTagDAOImpl.getPostTagDAOImpl().findPostsByTagId(tag.getId());
    }

    @Override
    public List<Post> findByCategoryCriteria(String criteria) throws DAOException, DBException {

        Filter filter = FilterDAOImpl.getFilterDAOImpl().findByCriteria(criteria);

        Category category = CategoryDAOImpl.getCategoryDAOImpl().findByName(filter.getName());

        return PostTagDAOImpl.getPostTagDAOImpl().findPostsByTagId(category.getId());
    }

}
