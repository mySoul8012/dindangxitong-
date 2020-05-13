package com.ming.demo.mapper;

import com.ming.demo.model.Order;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderMapper {
    //Order Mapper
    @Select("SELECT  * FROM `order`  where  category  = #{attributionCategory}")
    List<Order> findAllListOrder(@Param("attributionCategory")String attributionCategory);
}
