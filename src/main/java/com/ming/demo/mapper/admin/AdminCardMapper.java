package com.ming.demo.mapper.admin;

import com.ming.demo.model.Card;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AdminCardMapper {
    // 查询
    @Select("select * from card")
    public List<Card> findAllCard();

    // 增加
    @Insert("insert into card(faceValue, remainingFaceValue, createTime, expireDate, notes) values(#{card.faceValue}, #{card.remainingFaceValue}, #{card.createTime}, #{card.expireDate}, #{card.notes})")
    public int insertCard(Card card);

    // 删除
    @Delete("delete from card where id = #{id}")
    public int deleteCard(String id);

    // 更改
    @Update("update card set" +
            " faceValue = #{card.faceValue}" +
            " remainingFaceValue = #{card.remainingFaceValue}" +
            " createTime = #{card.createTime}" +
            " expireDate = #{card.expireDate}" +
            " notes = #{card.notes}" +
            " where id = #{card.id}")
    public int updateCard(Card card);
}
