package com.ming.demo.mapper.search;

import com.ming.demo.model.Goods;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SearchMapper {
    @Select("select * from goods where name like CONCAT('%', #{searchKeyWorld},'%')")
    public List<Goods> searchList(@Param("searchKeyWorld")String searchKeyWorld);
}
