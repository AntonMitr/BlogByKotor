package com.blog.by.kotor.postCategory;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PostCategoryId implements Serializable {

    private static final long serialVersionUID = 1L;

    private int postId;

    private int categoryId;

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostCategoryId that = (PostCategoryId) o;
        return postId == that.postId && categoryId == that.categoryId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, categoryId);
    }
}
