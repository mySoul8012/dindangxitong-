package com.ming.demo.bean.order;

import com.ming.demo.model.Goods;
import com.ming.demo.model.Order;
import com.ming.demo.model.UserAddress;

// 订单详情页
public class OrderDetails {
    private Order order;
    private UserAddress userAddress;
    private Goods goods;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public UserAddress getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(UserAddress userAddress) {
        this.userAddress = userAddress;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }
}
