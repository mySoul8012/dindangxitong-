package com.ming.demo.service.userOrders;

import com.ming.demo.mapper.UserAddress.UserAddressMapper;
import com.ming.demo.model.UserAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserOrdersService {
    @Autowired
    private UserAddressMapper userAddressMapper;

    // 读取用户默认订单地址
    public UserAddress getDefaultAddress(String id){
        // 读取用户默认下单地址
        return userAddressMapper.getDefaultUserAddress(id);
    }
}
