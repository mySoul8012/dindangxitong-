package com.ming.demo.mapper.UserAddress;

import com.ming.demo.model.Coupon;
import com.ming.demo.model.User;
import com.ming.demo.model.UserAddress;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
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

    @Insert("insert into userAddress(usernameId, address, states, remarks, isDefault,phone, sex, label ) values(#{userAddress.usernameId}, #{userAddress.address}, #{userAddress.states}, #{userAddress.remarks}, #{userAddress.isDefault}, #{userAddress.phone}, #{userAddress.sex}, #{userAddress.label})")
    int addInsertAddress(@Param("userAddress") UserAddress userAddress);
}
