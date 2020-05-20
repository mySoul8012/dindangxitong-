package com.ming.demo.web.userOrders;

import com.ming.demo.model.UserAddress;
import com.ming.demo.service.userOrders.UserOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/userOrder")
@RestController
public class UserOrderController {
    @Autowired
    private UserOrdersService userOrdersService;

    // 读取默认订单地址
    @RequestMapping("/userAddress")
    public UserAddress userAddress(String id){
        return userOrdersService.getDefaultAddress(id);
    }


}
