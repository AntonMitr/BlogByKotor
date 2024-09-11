package com.blog.by.kotor.post_category;

import com.blog.by.kotor.*;

import java.util.List;

public interface PostCategoryDAO extends DAO<PostCategory> {

    List<Post> findPostsByCategoryId(int categoryId) throws DAOException, DBException;

}
