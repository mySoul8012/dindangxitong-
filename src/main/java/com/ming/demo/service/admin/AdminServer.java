package com.ming.demo.service.admin;

import com.ming.demo.mapper.admin.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServer {
    @Autowired
    private AdminMapper adminMapper;


    public boolean login(String name, String password) {
        // 获取到数据
        // 获取到密码
        String password1 = adminMapper.getToPassword(name);
        System.out.println(password);
        System.out.println(password1);
        // 进行比较
        if(password.equals(password1)){
            //
            return true;
        }
        return false;
    }

    public String getId(String name) {
        return adminMapper.getAdminUser(name).getName();
    }
}
