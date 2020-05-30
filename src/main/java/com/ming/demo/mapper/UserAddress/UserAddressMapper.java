package com.ming.demo.mapper.UserAddress;

import com.ming.demo.model.Coupon;
import com.ming.demo.model.Order;
import com.ming.demo.model.User;
import com.ming.demo.model.UserAddress;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserAddressMapper {

    // 根据用户id查询默认地址
    @Select("select * from userAddress where usernameId = #{userId} and isDefault = '1'")
    public UserAddress getDefaultUserAddress(@Param("userId")String userId);

    // 根据用户id查询所有地址
    @Select("select * from userAddress where usernameId = #{userId}")
    public List<UserAddress> getUserAddress(@Param("userId")String userId);

    // 获取该用户下的优惠券。
    @Select("select * from user where id = #{id}")
    public User getUserCoupon(String id);

    // 增加地址
    @Insert("insert into userAddress(usernameId, address, states, remarks, isDefault,phone, sex, label , recipient) values(#{userAddress.usernameId}, #{userAddress.address}, #{userAddress.states}, #{userAddress.remarks}, #{userAddress.isDefault}, #{userAddress.phone}, #{userAddress.sex}, #{userAddress.label}, #{userAddress.recipient})")
    int addInsertAddress(@Param("userAddress") UserAddress userAddress);

    // 增加订单
    @Insert("insert into `order`(name, deliveryAddress, amount, status, category, remarks, serviceHours, price, orderCreatorId, serviceTime, shoopId, createTime) " +
            " values(#{order.name}, #{order.deliveryAddress}, #{order.amount}, #{order.status}, #{order.category}, #{order.remarks},#{order.serviceHours}, #{order.price}, #{order.orderCreatorId}, #{order.serviceTime}, #{order.shoopId}, now())")
    int insertInToOrder(@Param("order") Order order);

    // 更新库存
    @Update("update goods set stock = stock - 1 where id = #{shoopId}")
    int updateStockGoods(@Param("shoopId") String shoopId);

    // 更新库存为0
    @Update("update goods set stock = 0 where id = #{shoopId}")
    int updateStock0Goods(@Param("shoopId")String shoopId);


    @Update("update `order` set status = 2 where id = #{id}")
    int cancelOrder(String id);

    @Select("select * from `order` where orderCreatorId = #{id}")
    List<Order> findAllUserOrder(String id);

    @Select("select * from `order` where orderCreatorId = #{id} and status = 1 ")
    List<Order> findAllToBePaid(String id);

    @Select("select * from `order` where orderCreatorId = #{id} and status = 4 ")
    List<Order> findAllToBeServed(String id);

    @Select("select * from `order` where orderCreatorId = #{id} and status = 5")
    List<Order> findAllCompleted(String id);

    @Delete("delete from userAddress where id = #{id}")
    int deleteAddress(String id);
}
