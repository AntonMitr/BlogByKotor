package com.blog.by.kotor.post_tag;

import com.blog.by.kotor.DAO;
import com.blog.by.kotor.Post;
import com.blog.by.kotor.PostTag;

import java.util.List;

public interface PostTagDAO extends DAO<PostTag> {
    List<Post> findPostsByTagId(int tagId);
}
