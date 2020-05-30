package com.ming.demo.service.admin;

import com.github.pagehelper.PageHelper;
import com.ming.demo.mapper.admin.AdminOrderMapper;
import com.ming.demo.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AminOrderServer {
    @Autowired
    private AdminOrderMapper adminOrderMapper;

    public List<Order> test(){
        return  adminOrderMapper.listOrder();
    }

    // 查询
    public List<Order> findAll(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        return adminOrderMapper.listOrder();
    }

    // 增加
    public boolean inserOne(Order order) {
        // 进行插入
        if(adminOrderMapper.insertInto(order) == 1) {
            return true;
        }
        return false;
    }

    // 删除
    public boolean delete(String id) {
        // 进行删除
        if(adminOrderMapper.delete(id) == 1){
            return true;
        }
        return false;
    }

    // 进行更新
    public boolean update(Order order){
        if(adminOrderMapper.updateAdminOrder(order) == 1){
            // 此时返回true
            return true;
        }
        return false;
    }
}
