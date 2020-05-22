package com.ming.demo.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ming.demo.bean.Result;
import com.ming.demo.mapper.UserMapper;
import com.ming.demo.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Deprecated
public class TestController {

    @Autowired
    private UserMapper userMapper;

    public List<Order> OverdueOrder(Integer pageNum){
        PageHelper.startPage(pageNum, 5);
        List<Order> orderList = userMapper.getUnpaidOrder();
        PageInfo<Order> pageInfo = new PageInfo<Order>(orderList);
        System.out.println(pageInfo.getPages());
        System.out.println();
        return orderList;
    }
}
