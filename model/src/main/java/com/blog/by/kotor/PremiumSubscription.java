package com.blog.by.kotor;

import java.sql.Date;

public class PremiumSubscription {

    private int id;
    private int userId;
    private Date startDate;
    private Date endDate;

    public PremiumSubscription(int id, int user_id, Date start_date, Date end_date) {
        this.id = id;
        this.userId = user_id;
        this.startDate = start_date;
        this.endDate = end_date;
    }

    public PremiumSubscription() {

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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "PremiumSubscription{" +
                "id=" + id +
                ", user_id=" + userId +
                ", start_date=" + startDate +
                ", end_date=" + endDate +
                '}';
    }

}
