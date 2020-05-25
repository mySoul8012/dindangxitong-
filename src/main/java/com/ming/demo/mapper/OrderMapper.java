package com.ming.demo.mapper;

import com.ming.demo.model.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderMapper {
    //Order Mapper
    @Select("SELECT  * FROM `order`  where  category  = #{attributionCategory}")
    List<Order> findAllListOrder(@Param("attributionCategory")String attributionCategory);

    @Insert("insert into `order`(name, deliveryAddress, amount, status, category, remarks, serviceHours, price, orderCreatorId, serviceTime, shoopId, createTime) " +
            "values(#{order.name}, #{order.deliveryAddress}, #{order.amount}, #{order.status}, #{order.category}, #{order.remarks}, #{order.serviceHours}, #{order.price}, #{order.orderCreatorId}, #{order.serviceTime}, #{order.shoopId}, now())")
    int insertInto(@Param("order")Order order);
}
