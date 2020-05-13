package com.ming.demo.web;

import com.ming.demo.mapper.OrderMapper;
import com.ming.demo.mapper.UserMapper;
import com.ming.demo.model.Order;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

// 订单控制器
@Api(tags = "订单")
@RestController
public class addOrderController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OrderMapper orderMapper;

    // 获取当前用户分类下的所有的订单
    @RequestMapping("/findAllOrder")
    @ApiOperation("获取当前用户分类下的所有的订单")
    public List<Order> findOrderAll(HttpSession httpSession){
        // 获取当前用户分类下的所有的订单
        // 获取当前用户id
        String id = (String)httpSession.getAttribute("login");
        // 获取用户所属的分类
        String attributionCategoryId = userMapper.getAttributionCategoryId(id);

        // 查询分类的所有订单
        return orderMapper.findAllListOrder(attributionCategoryId);
    }

    @RequestMapping("/test")
    @ApiOperation("/测试")
    public String test(){
        return "test";
    }
}
