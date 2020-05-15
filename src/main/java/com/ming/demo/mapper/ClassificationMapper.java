package com.ming.demo.mapper;

import com.ming.demo.model.Classification;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ClassificationMapper {
    // 查询所有的分类
    @Select("select * from classification")
    List<Classification> findAll();

    // 根据id查询分类名称
    @Select("select name from classification where id = #{id}")
    String findIdCategoryName(@Param("id")String id);

    // 根据id查询分类备注
    @Select("select notes from classification where id = #{id}")
    String findIdCategoryNotes(@Param("id")String id);
}
