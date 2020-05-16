package com.ming.demo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "商品类")
public class Goods {
    @ApiModelProperty(value = "ID", example = "1")
    private int id;
    @ApiModelProperty(value = "商品名称", example = "ming3")
    private String name;
    @ApiModelProperty(value="商品价格", example = "1.2")
    private String commodityPrice;
    @ApiModelProperty(value = "商品所属分类", example = "1")
    private String classification;
    @ApiModelProperty(value = "商品图片Url", example = "")
    private String imgUrl;
    @ApiModelProperty(value = "商品副标题", example = "商品副标题")
    private String subtitle;
    @ApiModelProperty(value = "商品详情页", example = "商品详情页")
    private String details;
    @ApiModelProperty(value = "库存", example = "1000")
    private String stock;
    @ApiModelProperty(value = "状态", example = "1")
    private String states;
    @ApiModelProperty(value = "评价id", example = "1")
    private String evaluationld;
    @ApiModelProperty(value = "备注", example = "备注信息")
    private String notes;
    private String time;
    private String label;
    private String discountPrice;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(String discountPrice) {
        this.discountPrice = discountPrice;
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

    public String getCommodityPrice() {
        return commodityPrice;
    }

    public void setCommodityPrice(String commodityPrice) {
        this.commodityPrice = commodityPrice;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getStates() {
        return states;
    }

    public void setStates(String states) {
        this.states = states;
    }

    public String getEvaluationld() {
        return evaluationld;
    }

    public void setEvaluationld(String evaluationld) {
        this.evaluationld = evaluationld;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
