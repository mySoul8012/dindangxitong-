package com.ming.demo.service.userOrders;

import com.ming.demo.mapper.UserAddress.UserAddressMapper;
import com.ming.demo.mapper.card.CardMapper;
import com.ming.demo.mapper.coupon.CouponMapper;
import com.ming.demo.mapper.goods.GoodsMapperGoods;
import com.ming.demo.mapper.shop.ShopMapper;
import com.ming.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    // 读取用户默认订单地址
    public UserAddress getDefaultAddress(String id){
        // 读取用户默认下单地址
        return userAddressMapper.getDefaultUserAddress(id);
    }

    // 读取所有的地址
    public List<UserAddress> getUserAddress(String id){
        return userAddressMapper.getUserAddress(id);
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
}
