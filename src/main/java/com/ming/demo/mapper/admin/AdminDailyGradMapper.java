package com.ming.demo.mapper.admin;

import com.ming.demo.model.DailyGrab;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AdminDailyGradMapper {
    // 查询
    @Select("select * from dailyGrab")
    public List<DailyGrab> findAllDailyGrad();

    // 增加
    @Insert("insert into dailyGrab('goodsId') values(#{goodsId})")
    public int insertAllDailyGrad(String goodsId);

    // 修改
    @Update("update dailyGrab set goodsId = #{dailyGrad.goodsId} where id = #{dailyGrad.id}")
    public int updateDailyGrad(DailyGrab dailyGrab);

    // 删除
    @Delete("delete from dailyGrab where id = #{id}")
    public int deleteDailyGrad(String id);
}
