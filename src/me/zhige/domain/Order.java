package me.zhige.domain;

import java.util.Date;

public class Order {
    private Integer id;

    private String name;

    private String deliveryaddress;

    private String amount;

    private String status;

    private String category;

    private String remarks;

    private String price;

    private String servicetime;

    private Date servicehours;

    private String ordercreatorid;

    private Integer shoopid;

    private Date createtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDeliveryaddress() {
        return deliveryaddress;
    }

    public void setDeliveryaddress(String deliveryaddress) {
        this.deliveryaddress = deliveryaddress == null ? null : deliveryaddress.trim();
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount == null ? null : amount.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public String getServicetime() {
        return servicetime;
    }

    public void setServicetime(String servicetime) {
        this.servicetime = servicetime == null ? null : servicetime.trim();
    }

    public Date getServicehours() {
        return servicehours;
    }

    public void setServicehours(Date servicehours) {
        this.servicehours = servicehours;
    }

    public String getOrdercreatorid() {
        return ordercreatorid;
    }

    public void setOrdercreatorid(String ordercreatorid) {
        this.ordercreatorid = ordercreatorid == null ? null : ordercreatorid.trim();
    }

    public Integer getShoopid() {
        return shoopid;
    }

    public void setShoopid(Integer shoopid) {
        this.shoopid = shoopid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}