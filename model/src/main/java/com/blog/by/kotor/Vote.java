package com.blog.by.kotor;

import java.util.Objects;

public class Vote {

    private int id;
    private int postId;
    private int userId;
    private int optionId;

    public Vote(int id, int postId, int userId, int optionId) {
        this.id = id;
        this.postId = postId;
        this.userId = userId;
        this.optionId = optionId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getOptionId() {
        return optionId;
    }

    public void setOptionId(int optionId) {
        this.optionId = optionId;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "id=" + id +
                ", optionId=" + optionId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vote vote = (Vote) o;
        return id == vote.id && optionId == vote.optionId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, optionId);
    }

}
