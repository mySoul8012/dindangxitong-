package com.ming.demo.mapper.admin;

import com.ming.demo.model.Order;
import com.ming.demo.model.Shop;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AdminShopMapper {
    @Select("select * from shop")
    List<Shop> findAll();

    @Insert("insert into shop(shopName, imgUrl, createTime, notes, updateTime, states, phone) " +
            " values(#{shop.shopName}, #{shop.imgUrl}, #{shop.createTime}, #{shop.notes}, #{shop.updateTime}, #{shop.states}, #{shop.phone})")
    int insert(Shop shop);

    @Delete("delete from shop where id = #{id}")
    int deleteShop(String id);

    @Update("update shop set shopName = #{shop.shopName}, imgUrl = #{shop.imgUrl}, createTime = #{shop.createTime}, notes = #{shop.notes}, updateTime = #{shop.updateTime}, states = #{shop.states}, phone = #{shop.phone}")
    int updateShop(Shop shop);
}
