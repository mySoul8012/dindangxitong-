package com.ming.demo.service;

import com.ming.demo.mapper.GoodsMapper;
import com.ming.demo.mapper.OrderMapper;
import com.ming.demo.model.Goods;
import com.ming.demo.model.Order;
import com.ming.demo.model.UserAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private GoodsMapper goodsMapper;

    // 添加订单
    public boolean addOrder(Order order){
        // 添加订单
        if(orderMapper.insertInto(order) == 1){
            // 已结添加
            return true;
        }else{
            return false;
        }
    }

    public Order findOrder(String orderId) {
        return orderMapper.findOrder(orderId);
    }

    public UserAddress findAllAddress(String deliveryAddress) {
        return orderMapper.findAllAddress(deliveryAddress);
    }

    public Goods findGoodsId(String shoopId) {
        return goodsMapper.getGood(shoopId);
    }

    public boolean updateAddress(UserAddress userAddress) {
        int res = orderMapper.updateAddress(userAddress);
        if(res == 1){
            return true;
        }
        return false;
    }
}
