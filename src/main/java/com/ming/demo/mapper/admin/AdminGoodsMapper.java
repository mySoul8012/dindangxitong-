package com.ming.demo.mapper.admin;

import com.ming.demo.model.Goods;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AdminGoodsMapper {
    @Select("select * from goods")
    List<Goods> getListGoods();


    @Insert("insert into goods(name, commodityPrice, classification, imgUrl, details, stock, states, evaluationId) values (" +
            "#{goods.name}, #{goods.commodityPrice}, #{goods.classification}, #{goods.imgUrl}, #{goods.details}, #{goods.stock}, #{goods.states}, #{goods.evaluationld}" +
            ")")
    int insertGoods(Goods goods);

    @Delete("delete from goods where id = #{id}")
    int deleteGoods(String id);

    @Update("update goods set name = #{goods.name}, " +
            " commodityPrice = #{goods.commodityPrice}" +
            ",classification = #{goods.classification}" +
            ",imgUrl = #{goods.imgUrl}" +
            ",subtitle = #{goods.subtitle}" +
            ",details = #{goods.details}" +
            ",stock = #{goods.stock}" +
            ",states = #{goods.states}" +
            ",evaluationId = #{goods.evaluationId}" +
            ",notes = #{goods.notes}" +
            ",time = #{goods.time}" +
            ",label = #{goods.label}" +
            ",discountPrice = #{goods.discountPrice}" +
            ",merchantServices = #{goods.merchantServices}" +
            ",sales = #{goods.sales}" +
            ",business = #{goods.business}" +
            "")
    int updateGoods(Goods goods);
}
