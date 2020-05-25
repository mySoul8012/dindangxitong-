package com.ming.demo.service.login;

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

    public boolean login(String code){
        // 获取code
        System.out.println(code);
        // 发送get请求，获取
        // 拼接URL
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=wx06095f43c2b2902b&secret=72b3363a51ecafb61feb5cfaff5bb321&js_code=" + code  +"&grant_type=authorization_code";
        String res = HttpClient4.doGet(url);
        // 结果写入mysql中， 过期变成不可用状态
        // 结果转换为bean

        return true;
    }

    public String getLonginId(String username) {
        return userMapper.getId(username);
    }
}
