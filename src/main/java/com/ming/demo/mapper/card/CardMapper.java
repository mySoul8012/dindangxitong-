package com.ming.demo.mapper.card;

import com.ming.demo.model.Card;
import com.ming.demo.model.Goods;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface CardMapper {

    @Select("select * from card where id = #{id}")
    public Card findgetCard(@Param("id")String id);

    @Select("select * from goods where id = #{id}")
    Goods getGoodsList(@Param("id")String id);
}
