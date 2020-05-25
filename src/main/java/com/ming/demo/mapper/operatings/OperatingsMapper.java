package com.ming.demo.mapper.operatings;


import com.ming.demo.model.Operating;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OperatingsMapper {
    @Select("select * from operating where userId = #{userId} and orderId = #{orderId}")
    List<Operating> operatings(@Param("userId") String userId,@Param("orderId") String orderId);
    // interface

}
