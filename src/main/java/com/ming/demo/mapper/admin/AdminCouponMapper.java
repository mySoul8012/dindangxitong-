package com.ming.demo.mapper.admin;

import com.ming.demo.model.Coupon;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

// 优惠券
public interface AdminCouponMapper {
    @Select("select * from coupon")
    public List<Coupon> findAllCoupon();

    // 增加
    @Insert("insert into coupon(name, couponPrice, exprieTime, notes, createTime, states) values(#{coupon.name}, #{coupon.couponPrice}, #{coupon.exprieTime}, #{coupon.states})")
    public int insertIntoCoupon(Coupon coupon);

    // 删除
    @Delete("delete from coupon where id = #{id}")
    public int deleteCoupon(String id);

    // 修改
    @Update("update coupon set name = #{coupon.name}, couponPrice = #{coupon.couponPrice}, " +
            " exprieTime = #{coupon.exprieTime}, notes = #{coupon.notes}, createTime = #{coupon.createTime}" +
            " states = #{coupon.states}")
    public int updateCoupon(Coupon coupon);



}
