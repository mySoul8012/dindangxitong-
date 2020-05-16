package com.ming.demo.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DailyGradMapper {
    // 根据id查询，goodsId
    @Select("select goodsId from dailyGrab")
    public List<Integer> getGoodsId();
}
