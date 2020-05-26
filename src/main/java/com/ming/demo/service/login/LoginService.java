package com.ming.demo.service.login;

import com.alibaba.fastjson.JSON;
import com.ming.demo.bean.weichat.WeiChat;
import com.ming.demo.mapper.UserMapper;
import com.ming.demo.model.User;
import com.ming.demo.utils.HttpClient4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UserMapper userMapper;

    public Boolean login(String username, String password) {
        // 进行登录
        // 查询出用户密码
        String password1 = userMapper.getPassword(username);
        // 进行比较
        if(password.equals(password1)){
            // 如果这俩相等
            return true;
        }else{
            return false;
        }
    }

    public User login(String code){
        // 获取code
        System.out.println(code);
        // 发送get请求，获取
        // 拼接URL
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=wx06095f43c2b2902b&secret=72b3363a51ecafb61feb5cfaff5bb321&js_code=" + code  +"&grant_type=authorization_code";
        String res = HttpClient4.doGet(url);
        // 结果写入mysql中， 过期变成不可用状态
        WeiChat weiChat = JSON.parseObject(res, WeiChat.class);
        System.out.println(weiChat);
        // 结果转换为bean
        // 查询用户是否存在
        User user = userMapper.getUserName(weiChat.getOpenid());
        if(user == null){
            // 添加用户
            User user1 = new User();
            user1.setName(weiChat.getOpenid());
            user1.setPassword(weiChat.getSession_key());
            user1.setAttributionCategoryId(1);
            user1.setStatus("1");
            int resInt1 = userMapper.insertUser(user1);
            if(resInt1 == 1){
                // 根据id查询User
                user1 = userMapper.getUserName(weiChat.getOpenid());
            }
            return user1;
        }else{
            // 更新用户
            int resInt = userMapper.updatePassword(weiChat.getSession_key(), weiChat.getOpenid());
            if(resInt == 1){
                return user;
            }
        }
        return null;
    }

    public String getLonginId(String username) {
        return userMapper.getId(username);
    }
}
