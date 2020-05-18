package com.ming.demo.bean.goods;

// 商品评价
public class Valuation {
    // 评价用户头像
    private String imgUrl;
    // 评价用户名称
    private String name;
    // 用户是否是VIP
    private String isItVip;
    // 用户评价星级
    private String star;
    // 评价时间
    private String time;
    // 评价内容详情
    private String details;

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsItVip() {
        return isItVip;
    }

    public void setIsItVip(String isItVip) {
        this.isItVip = isItVip;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
