package com.blog.by.kotor.service;

import com.blog.by.kotor.model.post.tag.PostTag;

import java.util.List;

public interface PostTagService {

    void createPostTag(PostTag postTag);

    PostTag getPostTagById(int id);

    List<PostTag> getAllPostTag();

    void updatePostTag(PostTag postTag);

    void deletePostTagById(int id);

    void deletePostTag(PostTag postTag);

}
