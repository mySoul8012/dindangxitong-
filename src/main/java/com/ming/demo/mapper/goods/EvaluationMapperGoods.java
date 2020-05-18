package com.ming.demo.mapper.goods;

import com.ming.demo.model.Evaluation;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

// 评论接口
public interface EvaluationMapperGoods {
    // 根据商品id查询评论id列表
    @Select("select * from evaluation where goodsId = #{goodsId}")
    public List<Evaluation> evaluations(@Param("goodsId")String goodsId);
}
