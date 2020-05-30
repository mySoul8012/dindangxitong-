package com.ming.demo.mapper.rider;

import com.ming.demo.model.Rider;
import org.apache.ibatis.annotations.Select;

public interface RiderMapper {
    // 根据用户名查询用户
    @Select("select * from rider where name = #{name}")
    public Rider findAllRider(String name);

}
