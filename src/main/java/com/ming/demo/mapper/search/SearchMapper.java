package com.ming.demo.mapper.search;

import com.ming.demo.model.Goods;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SearchMapper {
    @Select("select * from goods where name like CONCAT('%', #{searchKeyWorld},'%')")
    public List<Goods> searchList(@Param("searchKeyWorld")String searchKeyWorld);

    @Select("<script>" +
            "select * from goods where 1 =1 " +
            "<when test='keyWorld != null'>" +
            "and name like CONCAT('%', #{keyWorld}, '%')" +
            "</when>" +
            // 最高价和最低价筛选
            " and commodityPrice between convert(#{lowestPrice}, decimal(9,4)) and convert(#{heighestPrice}, decimal(9,4))" +
            // 服务类型
            "<when test='merchantServices != null and merchantServices == 1'>" +
            " and merchantServices = 1 " +
            "</when>" +
            "<when test='merchantServices != null and merchantServices == 2'>" +
            " and merchantServices = 2" +
            "</when>" +
            // 所属分类
            "<when test='category != null and category != 0'>" +
            " and classification = 2" +
            "</when>" +
            // 默认排序
            "<when test='sort != null and sort == 1'>" +
            " order by name, commodityPrice desc " +
            "</when>" +
            // 销售量排序 从高到低
            "<when test='sort != null and sort == 2'>" +
            " order by convert(sales, decimal(9,4)) desc " +
            "</when>" +
            // 销售量排序 从低到高
            "<when test='sort != null and sort == 3'>" +
            " order by convert(sales, decimal(9,4)) asc " +
            "</when>" +
            // 价格从高到低
            "<when test='sort != null and sort == 4'>" +
            " order by convert(commodityPrice, decimal(9,4)) desc " +
            "</when>" +
            // 价格从低到高
            "<when test='sort != null and sort == 5'>" +
            " order by convert(commodityPrice, decimal(9,4)) asc " +
            "</when>" +
            " limit  #{Previous},#{next}" +
            "</script>")
    public List<Goods> searchListTwoVersion(@Param("keyWorld")String keyWorld, @Param("sort")String sort, @Param("heighestPrice")String heighestPrice, @Param("lowestPrice")String lowestPrice, @Param("merchantServices")String merchantServices, @Param("category")String category, @Param("Previous")int Previous, @Param("next")int next);
}
