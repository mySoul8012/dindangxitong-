package com.ming.demo.mapper;

import com.ming.demo.model.Order;
import com.ming.demo.model.UserAddress;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface OrderMapper {
    //Order Mapper
    @Select("SELECT  * FROM `order`  where  category  = #{attributionCategory}")
    List<Order> findAllListOrder(@Param("attributionCategory")String attributionCategory);

    @Insert("insert into `order`(name, deliveryAddress, amount, status, category, remarks, serviceHours, price, orderCreatorId, serviceTime, shoopId, createTime) " +
            "values(#{order.name}, #{order.deliveryAddress}, #{order.amount}, #{order.status}, #{order.category}, #{order.remarks}, #{order.serviceHours}, #{order.price}, #{order.orderCreatorId}, #{order.serviceTime}, #{order.shoopId}, now())")
    int insertInto(@Param("order") Order order);

    // 根据分类查询order
    @Select("select * from `order` where category = #{category} and status = 3")
    List<Order> findAllOrderCategory(@Param("category")String category);

    @Update("update `order` set status = 4 where id = #{id}")
    int updateStatesFor(String id);

    @Insert("insert into operating(orderId, name, time, userId) values(#{userId}, '订单被接单', now(), #{orderId})")
    int insertOperating(String userId, String orderId);

    @Select("select * from `order` where id = #{orderId}")
    Order findOrder(String orderId);

    @Select("select * from userAddress where id = #{deliveryAddress}")
    UserAddress findAllAddress(String deliveryAddress);

    @Update("update userAddress set usernameId = #{userAddress.usernameId} , address = #{userAddress.address} , states = #{userAddress.states} , remarks = #{userAddress.remarks}, isDefault = #{userAddress.isDefault} , phone = #{userAddress.phone}   , sex = #{userAddress.sex}, label = #{userAddress.label}  where id = #{userAddress.id}")
    int updateAddress(@Param("userAddress") UserAddress userAddress);
}
