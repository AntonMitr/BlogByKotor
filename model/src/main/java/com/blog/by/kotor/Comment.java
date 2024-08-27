package com.blog.by.kotor;

import java.sql.Date;

public class Comment {

    private int id;
    private String content;
    private Date createdAt;
    private int userId;
    private int postId;

    public Comment() {
    }

    public Comment(int id, String content, Date createdAt, int userId, int postId) {
        this.id = id;
        this.content = content;
        this.createdAt = createdAt;
        this.userId = userId;
        this.postId = postId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
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

    @Override
    public String toString() {
        return "comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", created_at=" + createdAt +
                ", user_id=" + userId +
                ", post_id=" + postId +
                '}';
    }

}
