package com.ming.demo.service.admin;

import com.github.pagehelper.PageHelper;
import com.ming.demo.mapper.admin.AdminUserMapper;
import com.ming.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminUserService {
    @Autowired
    private AdminUserMapper adminUserMapper;

    // 查询
    public List<User> findAll(int pageNo, int pageSize){
        PageHelper.startPage(pageNo, pageSize);
        return adminUserMapper.findAllUser();
    }

    // 删除
    public boolean delete(String id){
        int res = adminUserMapper.deleteUser(id);
        if(res == 1){
            return true;
        }
        return false;
    }

    // 增加
    public boolean insert(User user){
        int res =  adminUserMapper.insertUser(user);
        if(res == 1){
            return true;
        }
        return false;
    }

    // 改
    public boolean update(User user){
        int res = adminUserMapper.updateUser(user);
        if(res == 1){
            return true;
        }
        return false;
    }
}
