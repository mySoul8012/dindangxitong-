package com.ming.demo.mapper;

import com.ming.demo.model.Evaluation;
import org.apache.ibatis.annotations.*;

import java.util.List;

// 根据商品id，批量查询评论
public interface EvaluationMapper {
    @Select("select * from evaluation where goodsId = #{goodsId}")
    public List<Evaluation> evaluation(@Param("goodsId")String goodsId);

    @Select("select details from evaluation where goodsId = #{goodsId}")
    public String findDetailsById(@Param("goodsId")String goodsId);
}
