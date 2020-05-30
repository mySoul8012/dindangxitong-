package com.ming.demo.web.userOrders;

import com.ming.demo.bean.Result;
import com.ming.demo.bean.order.OrderDetails;
import com.ming.demo.model.*;
import com.ming.demo.service.OrderService;
import com.ming.demo.service.userOrders.UserOrdersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/userOrder")
@RestController
@Api(tags = "用户下订单")
public class UserOrderController {
    @Autowired
    private UserOrdersService userOrdersService;

    @Autowired
    private OrderService orderService;

    // 读取默认订单地址
    @RequestMapping("/userAddress")
    @ApiOperation(value = "读取默认订单地址")
    public UserAddress userAddress(String id){
        return userOrdersService.getDefaultAddress(id);
    }


    // 新增加地址
    @RequestMapping("/insertAddress")
    @ApiOperation(value = "增加新的地址")
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

    // 删除地址
    @RequestMapping("/deleteAddress")
    @ApiOperation("/删除地址")
    public Result deleteAddress(String id){
        // 删除地址
        boolean res = userOrdersService.deleteAddress(id);
        Result result = new Result();
        if(res){
            result.setMsg("success");
        }else{
            result.setMsg("error");
        }
        return result;
    }


    // 读取全部订单地址
    @RequestMapping("/getAllUserAddress")
    @ApiOperation(value = "读取全部订单地址")
    public List<com.ming.demo.bean.address.UserAddress> getAllUserAddress(String userId){
        // 读取全部订单地址
        return userOrdersService.getUserAddress(userId);
    }


    // 获取 当前用户全部优惠券的内容
    @RequestMapping("/findAllCouponList")
    @ApiOperation(value = "获取当前用户全部优惠券的内容")
    public List<Coupon> findAllCouponList(String id){
        return userOrdersService.findAllCouponList(id);
    }

    // 获取当前用户卡信息
    @RequestMapping("/cardList")
    @ApiOperation(value = "获取当前用户卡信息")
    public List<Card> cardList(String id){
        // 获取当前用户卡信息
        return userOrdersService.cardList(id);
    }

    // 获取当前商品信息
    @RequestMapping("/goods")
    @ApiOperation("获取当前商品信息")
    public Goods goodsList(String id){
        // 获取当前商品信息
        return userOrdersService.getGoodsList(id);
    }

    // 获取商品所属的商家
    @RequestMapping("/owningBusiness")
    @ApiOperation("获取商品所属的商家")
    public Shop getOwningBusiness(String id){
        // 进行查询
        return userOrdersService.getOwningBusiness(id);
    }

    @RequestMapping("/insertInToOrder")
    @ApiOperation("增加新的订单")
    public Result insertInToOrder(Order order){
        // 进行增加
        return userOrdersService.insertInToOrder(order);
    }

    // 取消订单
    @RequestMapping("/cancelOrder")
    @ApiOperation("取消订单")
    public Result cancelOrder(String id){
        // 更改订单状态
        return userOrdersService.cancelOrder(id);
    }

    // 查询全部服务
    @ApiOperation("查询订单全部服务")
    @RequestMapping("/findAllUserOrder")
    public List<Order> findAllUserOrder(String id, int pageNo, int size){
        return userOrdersService.findAllUserOrder(id, pageNo, size );
    }

    // 查询待支付
    @RequestMapping("/toBePaid")
    @ApiOperation(value = "查询待支付订单")
    public List<Order> findAllToBePaid(String id, String pageNo, String size){
        return userOrdersService.findAllToBePaid(id, pageNo, size);
    }

    // 查询待服务
    @RequestMapping("/findAllToBeServed")
    @ApiOperation("查询待服务的 订单")
    public List<Order> findAllToBeServed(String id, int pageNo, int size){
        return userOrdersService.findAllToBeServed(id, pageNo, size);
    }

    // 查询已完成
    @RequestMapping("/findAllCompleted")
    @ApiOperation(value = "查询已完成的订单")
    public List<Order> findAllCompleted(String id, int pageNo, int size){
        return userOrdersService.findAllCompleted(id, pageNo, size);
    }

    // 查询订单历史记录
    @RequestMapping("/operating")
    @ApiOperation(value = "查询订单历史记录")
    public List<Operating> operatings(String userId, String orderId){
        // 根据id查询
        return userOrdersService.operatings(userId,orderId);
    }

    // 查询订单详情
    @RequestMapping("/orderDetails")
    public OrderDetails orderDetails(String orderId){
        // 查询订单
        Order order = orderService.findOrder(orderId);
        // 获取订单地址
        UserAddress userAddress = orderService.findAllAddress(order.getDeliveryAddress());
        // 获取商品信息
        Goods goods = orderService.findGoodsId(order.getShoopId());
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setGoods(goods);
        orderDetails.setOrder(order);
        orderDetails.setUserAddress(userAddress);
        return orderDetails;
    }

    // 对地址进行修改
    // 地址修改
    @RequestMapping("/updateAddress")
    public Result updateAddress(UserAddress userAddress){
        Result result = new Result();
        if(orderService.updateAddress(userAddress)){
            result.setMsg("succss");
            return result;
        }
        result.setMsg("error");
        return result;
    }
}
