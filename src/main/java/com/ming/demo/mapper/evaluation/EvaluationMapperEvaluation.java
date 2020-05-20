package com.ming.demo.mapper.evaluation;

import com.ming.demo.model.Evaluation;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface EvaluationMapperEvaluation {
    // 根据商品id查询评论
    @Select("select * from evaluation  where goodsId = #{goodsId} ")
    public List<Evaluation> evaluationList(@Param("goodsId")String goodsId);

    @Select("<script>select * from evaluation where goodsId = #{goodsId}" +
            "<when test='sort != 1'>" +
            " and category = #{sort}" +
            "</when>" +
            "<when test='isImg != null and isImg != 0'>" +
            " and isImg = #{isImg}" +
            "</when>" +
            "limit #{skipLine}, #{firstLine}" +
            "</script>")
    public List<Evaluation> evaluationList01(@Param("goodsId")String goodsId,
                                           @Param("sort")String sort,
                                            @Param("isImg")String isImg,
                                            @Param("skipLine")int skipLine,
                                             @Param("firstLine")int firstLine);
}
