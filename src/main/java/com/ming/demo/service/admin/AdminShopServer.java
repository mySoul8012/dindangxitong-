package com.ming.demo.service.admin;

import com.github.pagehelper.PageHelper;
import com.ming.demo.mapper.OrderMapper;
import com.ming.demo.mapper.admin.AdminShopMapper;
import com.ming.demo.model.Order;
import com.ming.demo.model.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminShopServer {
    @Autowired
    private AdminShopMapper adminShopMapper;

    public List<Shop> findAll(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        return adminShopMapper.findAll();
    }

    public boolean insertShop(Shop shop) {
        if(adminShopMapper.insert(shop) == 1){
            return true;
        }
        return false;
    }

    public boolean deleteShop(String id) {
        if(adminShopMapper.deleteShop(id) == 1){
            return true;
        }
        return false;
    }

    public boolean updateShop(Shop shop) {
        int res = adminShopMapper.updateShop(shop);
        if(res == 1){
            return true;
        }
        return false;
    }
}
