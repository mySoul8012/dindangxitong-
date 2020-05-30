package com.ming.demo.web.admin;

import com.ming.demo.model.Order;
import com.ming.demo.service.admin.AminOrderServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// 增删查改
@RestController
@RequestMapping("/admin/order")
public class AdminOrderController {
    @Autowired
    private AminOrderServer aminOrderServer;

    @RequestMapping("/test")
    public List<Order> test(){
       return aminOrderServer.test();
    }

    // 查询
    @RequestMapping("/findAll")
    public List<Order> findAll(int pageNo, int size){
        return aminOrderServer.findAll(pageNo, size);
    }

    // 增加
    @RequestMapping("/insert")
    public boolean insert(Order order){
        return aminOrderServer.inserOne(order);
    }

    // 删除
    @RequestMapping("/delete")
    public boolean delete(String id){
        return aminOrderServer.delete(id);
    }

    // 更新
    @RequestMapping("/update")
    public boolean update(Order order){
        return aminOrderServer.update(order);
    }
}
