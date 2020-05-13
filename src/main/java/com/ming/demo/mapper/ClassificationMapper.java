package com.ming.demo.mapper;

import com.ming.demo.model.Classification;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ClassificationMapper {
    // 查询所有的分类
    @Select("select * from classification")
    List<Classification> findAll();
}
