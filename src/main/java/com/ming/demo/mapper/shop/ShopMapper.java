package com.ming.demo.mapper.shop;

import com.ming.demo.model.Shop;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ShopMapper {
    @Select("select * from shop where id = #{id} ")
    Shop getShopId(@Param("id") String shop);
}
