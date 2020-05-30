package com.ming.demo.mapper.admin;

import com.ming.demo.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface AdminUserMapper {
    @Select("select * from user")
    public List<User> findAllUser();

    @Update("upload user set name = #{user.name}, " +
            " password = #{user.password} " +
            " time = #{user.time}" +
            " attributionCategoryId = #{user.attributionCategoryId}" +
            " comments = #{user.comments}" +
            " status = #{user.status}" +
            " imgUrl = #{user.imgUrl}" +
            " isItVip = #{user.isItVip}" +
            " card = #{user.card}" +
            " coupon = #{user.coupon} " +
            " where id = #{user.id} ")
    public int updateUser(@Param("user")User user);

    @Insert("insert into user(name, password, time, attributionCategoryId, comments, status, imgUrl, isItVip, card, coupon) values(" +
            "  #{user.name}, #{user.password}, #{user.time}, #{user.attributionCategoryId}, #{user.comments}, #{user.status}, #{user.imgUrl}, #{user.isItVip}, #{user.card}, #{user.coupon}" +
            ")")
    public int insertUser(@Param("user")User user);

    @Delete("delete from user where id = #{id}")
    public int deleteUser(@Param("id")String id);
}
