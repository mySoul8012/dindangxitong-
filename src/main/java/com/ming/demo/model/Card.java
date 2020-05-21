package com.ming.demo.model;

public class Card {
    private int id;
    private String faceValue;
    private String remainingFaceValue;
    private String createTime;
    private String expireDate;
    private String notes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(String faceValue) {
        this.faceValue = faceValue;
    }

    public String getRemainingFaceValue() {
        return remainingFaceValue;
    }

    public void setRemainingFaceValue(String remainingFaceValue) {
        this.remainingFaceValue = remainingFaceValue;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
