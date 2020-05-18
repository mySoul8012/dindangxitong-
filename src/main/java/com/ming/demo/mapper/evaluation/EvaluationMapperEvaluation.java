package com.ming.demo.mapper.evaluation;

import com.ming.demo.model.Evaluation;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface EvaluationMapperEvaluation {
    // 根据商品id查询评论
    @Select("select * from evaluation  where goodsId = #{goodsId} ")
    public List<Evaluation> evaluationList(@Param("goodsId")String goodsId);
}
