package com.ming.demo.web;

import com.ming.demo.mapper.UserMapper;
import com.ming.demo.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/getUsers")
    public List<User> getUsers(HttpSession session){
        return userMapper.getAll();
    }

    @RequestMapping("/getUser")
    public List<User> getUsers(){
        return userMapper.getAll();
    }

    @RequestMapping("/userName")
    public String userName(){
        return userMapper.getPassword("ming");
    }

    @RequestMapping("/userName1")
    public String userName1(){
        return userMapper.getId("ming");
    }
}
