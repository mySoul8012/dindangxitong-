package com.ming.demo.mapper;

import com.ming.demo.model.Order;
import com.ming.demo.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {
    @Select("select * from user")
    List<User> getAll();

    // 用户密码查询
    @Select("select password from user where name =  #{username}")
    String getPassword(@Param("username")String username);

    // 进行插入
    @Insert("insert into user(name, password, time, attributionCategoryId, status) values(#{user.name}, #{user.password}, now(), #{user.attributionCategoryId}, #{user.status})")
    int insertPassword(@Param("user") User user);

    // 获取到用户id
    @Select("select id from user where name =  #{username}")
    String getId(@Param("username")String username);

    // 获取到用户分类
    @Select("select attributionCategoryId from user where id =  #{username}")
    String getAttributionCategoryId(@Param("username")String username);

    // 根据用户id，查询相关的用户头像
    @Select("select imgUrl from user where id =  #{username}")
    String getIdImgUrl(@Param("username")String username);

    // 根据用户id，查询出用户
    @Select("select * from user where id = #{username}")
    User getIdUser(@Param("username")String id);

    @Select("select * from `order` where status = 1")
    List<Order> getUnpaidOrder();

    @Update("update `order` set status = 2 where id = #{id}")
    int updateStates(@Param("id")int id);
}
