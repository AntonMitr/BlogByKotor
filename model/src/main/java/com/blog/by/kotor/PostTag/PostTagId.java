package com.blog.by.kotor.PostTag;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PostTagId implements Serializable {

    private static final long serialVersionUID = 1L;

    private int postId;

    private int tagId;

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostTagId postTagId = (PostTagId) o;
        return postId == postTagId.postId && tagId == postTagId.tagId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, tagId);
    }

}
