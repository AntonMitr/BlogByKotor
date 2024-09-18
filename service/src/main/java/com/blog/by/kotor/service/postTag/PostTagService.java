package com.blog.by.kotor.service.postTag;

import com.blog.by.kotor.model.postTag.PostTag;

import java.util.List;

public interface PostTagService {

    void createPostTag(PostTag postTag);

    PostTag getPostTagById(Integer id);

    List<PostTag> getAllPostTag();

    void updatePostTag(PostTag postTag);

    void deletePostTagById(Integer id);

    void deletePostTag(PostTag postTag);

}
