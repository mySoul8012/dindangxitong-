package com.ming.demo.mapper.admin;

import com.ming.demo.model.DailyGrab;
import com.ming.demo.model.Evaluation;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AdminEvaluationMapper {
    // 获取全部
    @Select("select * from evaluation")
    public List<Evaluation> getList();

    // 增加
    @Insert("insert into evaluation(userId, star, label, details, notes,goodsId )" +
            " values(#{evaluation.userId}, #{evaluation.star}, #{evaluation.label}," +
            " #{evaluation.details}, #{evaluation.notes}, #{evaluation.goodsId})")
    public int insertEValuation(Evaluation evaluation);

    // 删
    @Delete("delete from evaluation where id = #{id}")
    public int deleteEvaluation(String id);

    // 改
    @Update("update evaluation set userId = #{evaluation.userId}, star = #{evaluation.star}" +
            ", label = #{evaluation.label}, details = #{evaluation.details}" +
            " , notes = #{evaluation.notes}, goodsId = #{evaluation.goodsId}" +
            " where id = #{evaluation.id}")
    public int updateEvaluation(Evaluation evaluation);
}
