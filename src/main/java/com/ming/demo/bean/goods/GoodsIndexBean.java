package com.ming.demo.bean.goods;

import java.util.List;

public class GoodsIndexBean {
    // 轮播图
    private String imgUrl;
    // 商品id
    private String id;
    // 商品价格
    private String commodityPrice;
    // 打折价
    private String discountPrice;
    // 商品名称
    private String name;
    // 商品副标题
    private String subTitle;
    // 销售量
    private String sales;
    // 图文详情
    private String details;
    // 评价 一共三条
    private List<Valuation> valuations;
    // 该商品评价总条数
    private String countValuation;

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCommodityPrice() {
        return commodityPrice;
    }

    public void setCommodityPrice(String commodityPrice) {
        this.commodityPrice = commodityPrice;
    }

    public String getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(String discountPrice) {
        this.discountPrice = discountPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getSales() {
        return sales;
    }

    public void setSales(String sales) {
        this.sales = sales;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public List<Valuation> getValuations() {
        return valuations;
    }

    public void setValuations(List<Valuation> valuations) {
        this.valuations = valuations;
    }

    public String getCountValuation() {
        return countValuation;
    }

    public void setCountValuation(String countValuation) {
        this.countValuation = countValuation;
    }
}
