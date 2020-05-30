package com.ming.demo.web.admin;

import com.ming.demo.bean.Result;
import com.ming.demo.mapper.admin.AdminOrderMapper;
import com.ming.demo.model.Order;
import com.ming.demo.model.Shop;
import com.ming.demo.service.admin.AdminShopServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// 商家增删查改
@RestController
@RequestMapping("/admin/shop")
public class AdminShopController {
    @Autowired
    private AdminShopServer adminShopServer;

    // 查询
    @RequestMapping("/findAll")
    public List<Shop> findAll(int pageNo, int pageSize){
        return adminShopServer.findAll(pageNo, pageSize);
    }

    // 增加
    @RequestMapping("/insertShop")
    public Result insertShop(Shop shop){
        Result result = null;
        if(adminShopServer.insertShop(shop)){
            result = new Result();
            result.setMsg("success");
            return result;
        }
        result = new Result();
        result.setMsg("error");
        return result;
    }

    // 删除
    @RequestMapping("/deleteShop")
    public Result deleteShop(String id){
        Result result = new Result();
        if(adminShopServer.deleteShop(id)){
            result.setMsg("success");
            return result;
        }
        result.setMsg("error");
        return result;
    }

    // 修改
    @RequestMapping("/updateShop")
    public Result updateShop(Shop shop){
        Result result = new Result();
        if(adminShopServer.updateShop(shop)){
            result.setMsg("success");
            return result;
        }
        result.setMsg("error");
        return result;
    }


}
