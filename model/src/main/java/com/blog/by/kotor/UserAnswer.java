package com.blog.by.kotor;

import java.sql.Date;
import java.util.Objects;

public class UserAnswer {

    private int id;
    private int questionId;
    private int userId;
    private int optionId;
    private String answerText;
    private Date createdAt;

    public UserAnswer(int id, int questionId, int userId, int optionId, String answerText, Date createdAt) {
        this.id = id;
        this.questionId = questionId;
        this.userId = userId;
        this.optionId = optionId;
        this.answerText = answerText;
        this.createdAt = createdAt;
    }

    public UserAnswer() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getOptionId() {
        return optionId;
    }

    public void setOptionId(int optionId) {
        this.optionId = optionId;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "UserAnswer{" +
                "id=" + id +
                ", questionId=" + questionId +
                ", userId=" + userId +
                ", optionId=" + optionId +
                ", answerText='" + answerText + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAnswer that = (UserAnswer) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
