package com.ming.demo.mapper.goods;

import com.ming.demo.model.Goods;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GoodsMapperGoods {
    @Select("select * from goods where classification = #{classification}")
    List<Goods> subcategories(@Param("classification")String classification);
}
