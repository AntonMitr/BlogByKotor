package com.blog.by.kotor.post_category;

import com.blog.by.kotor.DAO;
import com.blog.by.kotor.Post;
import com.blog.by.kotor.PostCategory;
import com.blog.by.kotor.post.PostDAO;

import java.util.List;

public interface PostCategoryDAO extends DAO<PostCategory> {

    List<Post> findPostsByCategoryId(int categoryId);

}
