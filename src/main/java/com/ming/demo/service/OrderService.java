package com.ming.demo.service;

import com.ming.demo.mapper.OrderMapper;
import com.ming.demo.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;

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
}
