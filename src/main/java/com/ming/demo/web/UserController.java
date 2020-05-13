package com.ming.demo.web;

import com.ming.demo.mapper.UserMapper;
import com.ming.demo.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@Api("用户测试接口")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/getUsers")
    @ApiOperation("获取到用户Users")
    public List<User> getUsers(HttpSession session){
        return userMapper.getAll();
    }

    @RequestMapping("/getUser")
    @ApiOperation("获取所有用户")
    public List<User> getUsers(){
        return userMapper.getAll();
    }

    @RequestMapping("/userName")
    @ApiOperation("获取用户名ming的密码")
    public String userName(){
        return userMapper.getPassword("ming");
    }

    @RequestMapping("/userName1")
    @ApiOperation("获取用户名ming的id")
    public String userName1(){
        return userMapper.getId("ming");
    }
}
