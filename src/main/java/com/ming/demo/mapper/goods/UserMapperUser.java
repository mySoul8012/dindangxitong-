package com.ming.demo.mapper.goods;

import com.ming.demo.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

// 用户mapper
public interface UserMapperUser {
    // 根据用户id获取用户对象
    @Select("select * from user where id = #{id}")
    User getUser(@Param("id")String id);
}
