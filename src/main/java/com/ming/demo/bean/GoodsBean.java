package com.ming.demo.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(description = "商品结果展示类")
public class GoodsBean {
    @ApiModelProperty("商品id")
    private int id;
    @ApiModelProperty("商品标题")
    private String title;
    @ApiModelProperty("商品副标题")
    private String subTitle;
    @ApiModelProperty("商品价格")
    private String commodityPrice;
    @ApiModelProperty("图片Url")
    private String imgUrl;
    @ApiModelProperty("分类名称")
    private String categoryName;
    @ApiModelProperty("分类备注")
    private String categoryNotes;
    @ApiModelProperty("评价列表")
    private List<EvaluationBean> evaluationBeanList;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getCommodityPrice() {
        return commodityPrice;
    }

    public void setCommodityPrice(String commodityPrice) {
        this.commodityPrice = commodityPrice;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryNotes() {
        return categoryNotes;
    }

    public void setCategoryNotes(String categoryNotes) {
        this.categoryNotes = categoryNotes;
    }

    public List<EvaluationBean> getEvaluationBeanList() {
        return evaluationBeanList;
    }

    public void setEvaluationBeanList(List<EvaluationBean> evaluationBeanList) {
        this.evaluationBeanList = evaluationBeanList;
    }
}
