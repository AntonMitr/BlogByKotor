package com.blog.by.kotor;

import java.sql.Date;

public class Post {

    private int id;
    private int userId;
    private String title;
    private String content;
    private Date datePublished;
    private boolean isPremium;
    private boolean isPublished;

    public Post(int id, int userId, String title, String content, Date datePublished, boolean isPremium, boolean isPublished) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.datePublished = datePublished;
        this.isPremium = isPremium;
        this.isPublished = isPublished;
    }

    public Post() {

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(Date datePublished) {
        this.datePublished = datePublished;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public void setPremium(boolean premium) {
        isPremium = premium;
    }

    public void isPremium(boolean isPremium) {
        this.isPremium = isPremium;
    }

    public boolean isPublished() {
        return isPublished;
    }

    public void setPublished(boolean isPublished) {
        this.isPublished = isPublished;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", user_id=" + userId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", date_published=" + datePublished +
                ", is_premium=" + isPremium +
                ", is_published=" + isPublished +
                '}';
    }

}
