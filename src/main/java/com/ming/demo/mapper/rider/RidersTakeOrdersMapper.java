package com.ming.demo.mapper.rider;

import org.apache.ibatis.annotations.Insert;

public interface RidersTakeOrdersMapper {

    @Insert("insert into ridersTakeOrders(orderId,rider, notes,  createTime) values(#{orderId}, #{userId}, '', now())")
    public int insertTakeOrders(String orderId, String userId);
}
