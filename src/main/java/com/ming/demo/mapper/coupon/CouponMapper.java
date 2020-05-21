package com.ming.demo.mapper.coupon;


import com.ming.demo.model.Coupon;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface CouponMapper {
    @Select("select * from coupon where id = #{id}")
    public Coupon getCoupon(@Param("id")String id);
}
