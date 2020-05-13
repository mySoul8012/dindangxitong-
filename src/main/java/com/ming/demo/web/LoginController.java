package com.ming.demo.web;

import com.ming.demo.bean.Result;
import com.ming.demo.mapper.UserMapper;
import com.ming.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;

// 登录控制器，用于进行登录注册
@RestController
public class LoginController {

    @Autowired
    private UserMapper userMapper;


    @RequestMapping("/login")
    public Result login(@RequestParam("username")String username, @RequestParam("password")String password, HttpSession httpSession){
        // 获取到用户密码
        String password1 = userMapper.getPassword(username);
        // 获取到用户id
        String id = userMapper.getId(username);
        // 进行对比
        if (password.equals(password1)){
            // 密码正确保存session，登录
            httpSession.setAttribute("login", id + "");
            Result result = new Result();
            result.setMsg("success");
            return result;
        }else{
            // 登录失败，返回error
            Result result = new Result();
            result.setMsg("error");
            return result;
        }

    }

    // 打印出session
    @RequestMapping("/getSession")
    public Result getSession(HttpSession httpSession){
        Object res = httpSession.getAttribute("login");
        Result result = new Result();
        result.setMsg((String)res);
        return result;
    }

    // 注册
    @PostMapping("/addUser")
    public Result addUser(User user){
        // 添加User
        int res = userMapper.insertPassword(user);
        Result result = new Result();
        result.setMsg(res + "");
        return result;
    }
}
