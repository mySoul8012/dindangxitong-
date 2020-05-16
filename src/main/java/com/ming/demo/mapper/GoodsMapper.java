package com.ming.demo.mapper;

import com.ming.demo.model.Goods;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GoodsMapper {
    // 查询所有的商品
    @Select("select * from goods where id = #{goodsId}")
    public Goods getGood(@Param("goodsId")String id);

    @Select("select * from goods")
    public List<Goods> getAllGoods();

    @Select("select * from goods limit 3")
    public List<Goods> getAllGoods3();

    // 查询四条商品数据
    @Select("select * from goods limit 4")
    public List<Goods> getAllGoods4();
}
