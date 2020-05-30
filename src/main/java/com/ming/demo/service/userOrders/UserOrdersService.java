package com.ming.demo.service.userOrders;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ming.demo.bean.Result;
import com.ming.demo.mapper.UserAddress.UserAddressMapper;
import com.ming.demo.mapper.UserMapper;
import com.ming.demo.mapper.card.CardMapper;
import com.ming.demo.mapper.coupon.CouponMapper;
import com.ming.demo.mapper.goods.GoodsMapperGoods;
import com.ming.demo.mapper.operatings.OperatingsMapper;
import com.ming.demo.mapper.shop.ShopMapper;
import com.ming.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class UserOrdersService {
    @Autowired
    private UserAddressMapper userAddressMapper;

    @Autowired
    private CouponMapper couponMapper;

    @Autowired
    private CardMapper cardMapper;


    @Autowired
    private GoodsMapperGoods goodsMapperGoods;

    @Autowired
    private ShopMapper shopMapper;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OperatingsMapper operatingsMapper;

    @Resource(name="stringRedisTemplate")
    ValueOperations<String, String> valOpsStr;

    // 读取用户默认订单地址
    public UserAddress getDefaultAddress(String id){
        // 读取用户默认下单地址
        return userAddressMapper.getDefaultUserAddress(id);
    }

    // 读取所有的地址
    public List<UserAddress> getUserAddress(String id){
        List<UserAddress> userAddresses = userAddressMapper.getUserAddress(id);
        //*
       // List<com.ming.demo.bean.address.UserAddress> userAddressArrayList= new ArrayList<>();
       // System.out.println(userAddressArrayList.size());
      //  for (UserAddress userAddress : userAddresses) {
        //    // 获取全部内容
        //    int usernameId = userAddress.getUsernameId();
        //    // 查询名称
        //    String userName = userMapper.getIdUser(usernameId + "").getName();
        //    com.ming.demo.bean.address.UserAddress userAddress1 = new com.ming.demo.bean.address.UserAddress();
        //    userAddress1.setName(userAddress.getRecipient());
        //    userAddress1.setAddress(userAddress.getAddress());
        //    userAddress1.setId(userAddress.getId());
        //    userAddress1.setIsDefault(userAddress.getIsDefault());
        //    userAddress1.setLabel(userAddress.getLabel());
       //     userAddress1.setPhone(userAddress.getPhone());
       //     userAddress1.setRemarks(userAddress.getRemarks());
       //     userAddress1.setSex(userAddress.getSex());
        //    userAddress1.setStates(userAddress.getStates());
       //     userAddress1.setUsernameId(userAddress.getUsernameId());
       //     userAddressArrayList.add(userAddress1);
      //  }
        //
        return userAddresses;
    }

    // 获取该用户下的优惠券
    public List<Coupon> findAllCouponList(String id){
        // 获取用户下的优惠券
        User user = userAddressMapper.getUserCoupon(id);
        // 获取该用户下的所有的优惠券列表
        String couponList = user.getCoupon();
        // 进行拆分
        String[] couponArray = couponList.split(",");
        // 进行遍历
        List<Coupon> list = new ArrayList<>();
        // 进行遍历
        for (String s : couponArray) {
            // 根据id查询优惠券的内容
            Coupon coupon = couponMapper.getCoupon(s);
            list.add(coupon);
        }
        return list;
    }


    public List<Card> cardList(String id){
        // 获取当前用户下用户信息
        User user = userAddressMapper.getUserCoupon(id);
        // 获取卡
        String cardList = user.getCard();
        // 拆分
        String[] cardList01 = cardList.split(",");
        List<Card> cards = new ArrayList<>();
        // 进行一下遍历
        for (String s : cardList01) {
            // 进行遍历
            Card card = cardMapper.findgetCard(s);
            cards.add(card);
        }
        return cards;
    }

    // 获取单个商品信息
    public Goods getGoodsList(String id) {
        return cardMapper.getGoodsList(id);
    }

    public Shop getOwningBusiness(String id) {
        // 查询商品信息
        Goods goods = goodsMapperGoods.getGood(id);
        // 查询商品信息列表信息
        String shop = goods.getBusiness();
        // 进行查询相关的店家
        return shopMapper.getShopId(shop);
    }

    public boolean addInsertAddress(UserAddress userAddress) {
        int line = userAddressMapper.addInsertAddress(userAddress);
        if(line == 1){
            return true;
        }
        return false;
    }

    // 下单 service  库存减一 订单增加一条记录
    // 需要增加 service 分布式锁
    // 库存减少和订单增加，需要原子性操作
    public Result insertInToOrder(Order order) {
        // 锁资源放入redis中
        valOpsStr.setIfAbsent("key", "value");
        // 设置锁的过期时间
        stringRedisTemplate.expire("key", 30000, TimeUnit.MILLISECONDS);
        // 减少库存
        int stockLine = userAddressMapper.updateStockGoods(order.getShoopId());
        // 查询剩余库存
        int resStock = Integer.parseInt(goodsMapperGoods.getGood(order.getShoopId()).getStock());
        if(resStock < 0){
            // 已经卖完
            // 库存修改为0
            userAddressMapper.updateStock0Goods(order.getShoopId());
            Result result = new Result();
            result.setMsg("error");
            return result;
        }
        // 增加订单
        int res = userAddressMapper.insertInToOrder(order);
        // 释放锁
        stringRedisTemplate.delete("key");
        if(res == 1 && stockLine == 1){
            // mapper增加
            Result result = new Result();
            // 添加
            result.setMsg("success");
            return result;
        }else{
            Result result = new Result();
            result.setMsg("error");
            return result;
        }
    }


    // 扫描超时的订单
    // 一条一条记录读取，orders
    public void OverdueOrder() throws ParseException {
        int pageNum = 0;
        int pages = 0;
        PageHelper.startPage(pageNum, 5);
        List<Order> orderList = userMapper.getUnpaidOrder();
        PageInfo<Order> pageInfo = new PageInfo<Order>(orderList);
        pages = pageInfo.getPages();
        // 进行判断超时订单
        for(int i = 0; i <= pages; i++){
            // 启动分页
            PageHelper.startPage(i,5);
            List<Order> orderList1 = userMapper.getUnpaidOrder();
            // 判断超时处理
            // 获取时间
            for (Order order : orderList1) {
                System.out.println(order.getId());
                // 获取创建时间戳
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                // 进行转化
                Date createTime = simpleDateFormat.parse(order.getCreateTime());
                // 获取时间戳
                long printoTocreateTime = createTime.getTime();
                System.out.println(printoTocreateTime);
                // 时间加十五分钟
                Date lastTime = new Date(createTime.getTime() + 15*60*1000);
                System.out.println(lastTime.getTime() + 15*60*1000);
                // 获取时间戳
                long lastToCreateTime = lastTime.getTime() + 15*60*1000;
                // 获取当前时间戳
                long nowTime = System.currentTimeMillis();
                System.out.println(nowTime);
                // 进行比较
                if(nowTime <= lastToCreateTime){
                    // 订单未超时
                }else{
                    // 订单超时
                    // 更新该订单的状态
                    int res = userMapper.updateStates(order.getId());
                }
            }
        }
    }

    public Result cancelOrder(String id) {
        int res = userAddressMapper.cancelOrder(id);
        if(res == 1){
            Result result = new Result();
            result.setMsg("success");
            return result;
        }else{
            Result result = new Result();
            result.setMsg("error");
            return result;
        }
    }

    // 我的服务查询
    public List<Order> findAllUserOrder(String id, int pageNo, int size) {
        // 启动分页
        PageHelper.startPage(pageNo, size);
        return userAddressMapper.findAllUserOrder(id);
    }

    public List<Order> findAllToBePaid(String id, String pageNo, String size) {
        PageHelper.startPage(Integer.parseInt(pageNo), Integer.parseInt(size));
        return userAddressMapper.findAllToBePaid(id);
    }

    // 查询待服务
    public List<Order> findAllToBeServed(String id, int pageNo, int size) {
        PageHelper.startPage(pageNo, size);
        return userAddressMapper.findAllToBeServed(id);
    }

    public List<Order> findAllCompleted(String id, int pageNo, int size) {
        PageHelper.startPage(pageNo, size);
        return userAddressMapper.findAllCompleted(id);
    }

    public List<Operating> operatings(String userId, String orderId) {
        return operatingsMapper.operatings(userId, orderId);
    }

    public boolean deleteAddress(String id) {
        // 进行删除
        int res = userAddressMapper.deleteAddress(id);
        if(res == 1){
            return true;
        }else{
            return false;
        }
    }
}
