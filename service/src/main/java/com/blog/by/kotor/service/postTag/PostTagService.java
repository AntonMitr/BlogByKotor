package com.blog.by.kotor.service.postTag;

import com.blog.by.kotor.model.postTag.PostTag;

import java.util.List;

public interface PostTagService {

    void createPostTag(PostTag postTag);

    List<PostTag> findPostTagByTagId(Integer tagId);

    List<PostTag> findAllPostTag();

    void updatePostTag(PostTag postTag);

    void deletePostTag(PostTag postTag);

}
