package com.ming.demo.mapper.UserAddress;

import com.ming.demo.model.UserAddress;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserAddressMapper {

    // 根据用户id查询默认地址
    @Select("select * from userAddress where usernameId = #{userId} and isDefault = '1'")
    public UserAddress getDefaultUserAddress(@Param("userId")String userId);
}
