package com.ming.demo.model;

import java.util.Date;

public class User {
    private int id;
    private String name;
    private String password;
    private Date time;
    private int attributionCategoryId;
    private String comments;
    private String status;
    private String imgUrl;
    // 是否是VIP
    private String isItVip;
    private String card;
    private String coupon;

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getCoupon() {
        return coupon;
    }

    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }

    public String getIsItVip() {
        return isItVip;
    }

    public void setIsItVip(String isItVip) {
        this.isItVip = isItVip;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getAttributionCategoryId() {
        return attributionCategoryId;
    }

    public void setAttributionCategoryId(int attributionCategoryId) {
        this.attributionCategoryId = attributionCategoryId;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
