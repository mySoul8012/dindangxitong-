package com.ming.demo.mapper;

import com.ming.demo.model.Goods;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface GoodsMapper {
    // 查询所有的商品
    @Select("select * from goods where id = #{goodsId}")
    public Goods getGood(@Param("goodsId")String id);

}
