package com.ming.demo.mapper.admin;

import com.ming.demo.model.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface AdminOrderMapper {

    @Select("select * from `order`")
    List<Order> listOrder();

    @Insert("insert into `order`(name, deliveryAddress, amount, status, category, remarks, serviceHours, price, orderCreatorId, serviceTime, shoopId, createTime) " +
            "values(#{order.name}, #{order.deliveryAddress}, #{order.amount}, #{order.status}, #{order.category}, #{order.remarks}, #{order.serviceHours}, #{order.price}, #{order.orderCreatorId}, #{order.serviceTime}, #{order.shoopId}, now())")
    int insertInto(@Param("order")Order order);

    @Delete("delete from `order`  where id = #{id}")
    int delete(String id);

    @Update("update `order` set name = #{order.name}, " +
            "deliveryAddress = #{order.deliveryAddress}" +
            ", amount = #{order.amount}, status = #{status}" +
            ", category = #{order.category}, remarks = #{order.remarks}" +
            ", serviceHours = #{order.serviceHours}, price = #{order.price}" +
            ", orderCreatorId = #{order.orderCreatorId}, serviceTime = #{order.serviceTime}" +
            ", shoopId = #{order.shoopId}, createTime = #{order.createTime}" +
            ", where id = #{order.id}")
    int updateAdminOrder(Order order);
}
