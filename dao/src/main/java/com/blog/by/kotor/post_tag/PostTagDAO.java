package com.blog.by.kotor.post_tag;

import com.blog.by.kotor.*;

import java.util.List;

public interface PostTagDAO extends DAO<PostTag> {
    List<Post> findPostsByTagId(int tagId) throws DAOException, DBException;
}
