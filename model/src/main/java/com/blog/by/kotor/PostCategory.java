package com.blog.by.kotor;

import java.util.Objects;

public class PostCategory {

    private int postId;
    private int categoryId;

    public PostCategory(int postId, int categoryId) {
        this.postId = postId;
        this.categoryId = categoryId;
    }

    public PostCategory() {

    }

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
    public String toString() {
        return "PostCategory{" +
                "postId=" + postId +
                ", categoryId=" + categoryId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostCategory that = (PostCategory) o;
        return postId == that.postId && categoryId == that.categoryId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, categoryId);
    }

}
