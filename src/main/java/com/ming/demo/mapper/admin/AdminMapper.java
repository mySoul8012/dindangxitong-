package com.ming.demo.mapper.admin;

import com.ming.demo.model.Admin;
import com.ming.demo.service.admin.AdminServer;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface AdminMapper {
    @Select("select password from admin where name = #{name}")
    String getToPassword(String name);

    @Select("select * from admin where name = #{name}")
    Admin getAdminUser(@Param("name")String name);

}
