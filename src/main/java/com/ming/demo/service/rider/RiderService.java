package com.ming.demo.service.rider;

import com.ming.demo.mapper.OrderMapper;
import com.ming.demo.mapper.rider.RiderMapper;
import com.ming.demo.mapper.rider.RidersTakeOrdersMapper;
import com.ming.demo.model.Order;
import com.ming.demo.model.Rider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiderService {
    @Autowired
    private RiderMapper riderMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private RidersTakeOrdersMapper ridersTakeOrdersMapper;

    public boolean findAllRider(String name,String password){
        Rider rider = riderMapper.findAllRider(name);
        if(password.equals(rider.getPassword())){
            return true;
        }
        return false;
    }

    public String getLonginId(String name) {
        Rider rider = riderMapper.findAllRider(name);
        return rider.getPassword();
    }

    public Rider getRider(String username) {
        return riderMapper.findAllRider(username);
    }

    public List<Order> findRider(String category) {
        return orderMapper.findAllOrderCategory(category);
    }

    // 更新状态
    public int updateStates(String id) {
        return orderMapper.updateStatesFor(id);
    }

    // 写入订单历史记录
    public int insertOperating(String userId, String orderId) {
        return orderMapper.insertOperating(userId, orderId);
    }

    // 骑手端增加相关的历史记录
    public int insertTakeOrders(String orderId,String  userId) {
        return ridersTakeOrdersMapper.insertTakeOrders(orderId, userId);
    }
}
