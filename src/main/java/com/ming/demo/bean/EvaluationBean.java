package com.ming.demo.bean;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("评价展示结果类")
public class EvaluationBean {
    @ApiModelProperty("评价id")
    private int id;
    @ApiModelProperty("评价用户URL")
    private String userImgUrl;
    @ApiModelProperty("评价用户名称")
    private String userName;
    @ApiModelProperty("评价星级")
    private String starRating;
    @ApiModelProperty("评价标签")
    private String label;
    @ApiModelProperty("评价详情")
    private String details;
    @ApiModelProperty("评价时间")
    private String time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserImgUrl() {
        return userImgUrl;
    }

    public void setUserImgUrl(String userImgUrl) {
        this.userImgUrl = userImgUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getStarRating() {
        return starRating;
    }

    public void setStarRating(String starRating) {
        this.starRating = starRating;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
