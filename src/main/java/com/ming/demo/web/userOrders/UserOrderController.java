package com.ming.demo.web.userOrders;

import com.ming.demo.bean.Result;
import com.ming.demo.model.*;
import com.ming.demo.service.userOrders.UserOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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


    // 新增加地址
    @RequestMapping("/insertAddress")
    public Result addInsertAddress(UserAddress userAddress){
        if(userOrdersService.addInsertAddress(userAddress)){
            Result result = new Result();
            result.setMsg("success");
            return result;
        }else{
            Result result = new Result();
            result.setMsg("error");
            return result;
        }

    }


    // 读取全部订单地址
    @RequestMapping("/getAllUserAddress")
    public List<com.ming.demo.bean.address.UserAddress> getAllUserAddress(String userId){
        // 读取全部订单地址
        return userOrdersService.getUserAddress(userId);
    }


    // 获取 当前用户全部优惠券的内容
    @RequestMapping("/findAllCouponList")
    public List<Coupon> findAllCouponList(String id){
        return userOrdersService.findAllCouponList(id);
    }

    // 获取当前用户卡信息
    @RequestMapping("/cardList")
    public List<Card> cardList(String id){
        // 获取当前用户卡信息
        return userOrdersService.cardList(id);
    }

    // 获取当前商品信息
    @RequestMapping("/goods")
    public Goods goodsList(String id){
        // 获取当前商品信息
        return userOrdersService.getGoodsList(id);
    }

    // 获取商品所属的商家
    @RequestMapping("/owningBusiness")
    public Shop getOwningBusiness(String id){
        // 进行查询
        return userOrdersService.getOwningBusiness(id);
    }

    @RequestMapping("/insertInToOrder")
    public Result insertInToOrder(Order order){
        // 进行增加
        return userOrdersService.insertInToOrder(order);
    }
}
