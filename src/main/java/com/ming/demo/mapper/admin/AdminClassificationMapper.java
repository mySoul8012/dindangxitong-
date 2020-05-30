package com.ming.demo.mapper.admin;

import com.ming.demo.model.Classification;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AdminClassificationMapper {
    @Select("select * from classification ")
    public List<Classification> findAllClass();

    @Insert("insert into classification(name, creationDate, notes, status, imgUrl, parentCategory) " +
            " values(#{classification.name}, #{classification.creationDate}, #{classification.notes}, #{classification.status}, #{classification.imgUrl}, #{classification.parentCategory})")
    public int insertClassIfication(Classification classification);

    @Delete("delete from classification where id = #{id} ")
    public int deleteClassIfication(String id);

    @Update("update classification set name = #{classification.name},creationDate =  #{classification.creationDate}," +
            " notes =  #{classification.notes}, status =  #{classification.status},  imgUrl =#{classification.imgUrl}, parentCategory = #{classification.parentCategory} " +
            " where id =  #{classification.id}")
    public int updateClassIfication(Classification classification);

}
