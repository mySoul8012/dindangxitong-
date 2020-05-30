package com.ming.demo.web.admin;

import com.ming.demo.bean.Result;
import com.ming.demo.model.User;
import com.ming.demo.service.admin.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/user")
public class AdminUserController {
    @Autowired
    private AdminUserService adminUserService;

    // 增加
    @RequestMapping("/addUser")
    public Result addUser(User user){
        Result result = new Result();
        if(adminUserService.insert(user)){
            result.setMsg("succss");
            return result;
        }
        result.setMsg("error");
        return result;
    }

    // 删除
    @RequestMapping("/delete")
    public Result delete(String id){
        Result result = new Result();
        if(adminUserService.delete(id)){
            result.setMsg("succss");
            return result;
        }
        result.setMsg("error");
        return result;
    }

    // 更改
    @RequestMapping("/update")
    public Result update(User user){
        Result result = new Result();
        if(adminUserService.update(user)){
            result.setMsg("succss");
            return result;
        }
        result.setMsg("error");
        return result;
    }

    // 查询
    public List<User> userList(int pageNo, int pageSize){
        return adminUserService.findAll(pageNo,pageSize);
    }
}
