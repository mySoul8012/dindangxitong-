package com.ming.demo.web.rider.impl;

import com.github.pagehelper.PageHelper;
import com.ming.demo.bean.Audience;
import com.ming.demo.bean.Result;
import com.ming.demo.model.Order;
import com.ming.demo.model.Rider;
import com.ming.demo.service.rider.RiderService;
import com.ming.demo.utils.JwtTokenUtil;
import com.ming.demo.web.rider.RiderController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 */
@RestController
@RequestMapping("/rider")
public class RiderControllerImpl implements RiderController {

    @Autowired
    private RiderService riderService;

    @Autowired
    private Audience audience;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Resource(name="stringRedisTemplate")
    ValueOperations<String, String> valOpsStr;

    @Override
    @RequestMapping("/login")
    // 骑手登录
    public Result login(HttpServletResponse response, String name, String password) {
        // 获取密码
        // 进行登录
        if(riderService.findAllRider(name, password)){
            // 登录成功
            // 颁发jwt
            String userId = riderService.getLonginId(name);
            String role = "admin";
            // 创建Token
            String token = JwtTokenUtil.createJWT(userId, name, role, audience);
            System.out.println("登陆成功" + token);
            response.setHeader(JwtTokenUtil.AUTH_HEADER_KEY, JwtTokenUtil.TOKEN_PREFIX + token);
            Result result = new Result();
            result.setMsg(token);
            return result;
        }else{
            Result result = new Result();
            result.setMsg("error");
            return result;
        }
    }

    @Override
    @RequestMapping("/getRider")
    // 获取骑手信息
    public Rider getRider(String username) {
        // 获取骑手用户信息
        Rider rider = riderService.getRider(username);
        return rider;
    }


    @Override
    @RequestMapping("/findRiderOrder")
    // 查询骑手可以接的单
    public List<Order> findRiderOrder(String username, int pageNo, int pageSize) {
        // 查询骑手信息
        Rider rider = getRider(username);
        // 获取骑手分类id
        String classification = rider.getClassification();
        // 查询该分类下的所有订单
        PageHelper.startPage(pageNo, pageSize);
        return riderService.findRider(classification);
    }

    // 接单更改订单状态为未服务。并写入订单历史记录。传入订单id
    @Override
    @RequestMapping("/updateStatesOrder")
    // 骑手接单
    public Result updateStatesOrder(String orderId, String userId) {
        // 进行更新
        // 添加redis锁
        valOpsStr.setIfAbsent("key", "value");
        stringRedisTemplate.expire("key", 30000, TimeUnit.MILLISECONDS);

        // 更改订单状态，写入订单历史记录 骑手端增加相关的订单记录，用于钱数计算
        // 更改订单状态
        int resOrderStates = riderService.updateStates(orderId);
        // 写入订单历史记录
        int operating = riderService.insertOperating(orderId, userId);
        // 骑手端增加相关的接单记录
        int ridersTakeOrders = riderService.insertTakeOrders(orderId, userId);
        if(resOrderStates == 1 &&
           operating == 1 &&
            ridersTakeOrders == 1){
            // 跳过
        }else{
            // 释放锁
            stringRedisTemplate.delete("key");
            Result result = new Result();
            result.setMsg("error");
            return result;
        }

        // 释放锁
        stringRedisTemplate.delete("key");
        Result result = new Result();
        result.setMsg("success");
        return result;
    }
}
