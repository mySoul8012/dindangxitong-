package com.ming.demo.web.admin;

import com.ming.demo.bean.Result;
import com.ming.demo.model.DailyGrab;
import com.ming.demo.service.admin.AdminDailyGradService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/admin/dailyGrad")
public class AdminDailyGradController {
    @Autowired
    private AdminDailyGradService adminDailyGradService;


    // 增加
    @RequestMapping("/insert")
    public Result insert(DailyGrab dailyGrab){
        Result result = new Result();
        if(adminDailyGradService.insert(dailyGrab)){
            result.setMsg("success");
            return result;
        }
        result.setMsg("error");
        return result;
    }

    // 修改
    @RequestMapping("/update")
    public Result update(DailyGrab dailyGrab){
        Result result = new Result();
        if(adminDailyGradService.insert(dailyGrab)){
            result.setMsg("success");
            return result;
        }
        result.setMsg("error");
        return result;
    }

    // 读取
    @RequestMapping("/list")
    public List<DailyGrab> dailyGrabList(int pageNo, int pageSize){
        return adminDailyGradService.findAll(pageNo, pageSize);
    }

    // 删除
    @RequestMapping("/delete")
    public Result delete(String id){
        Result result = new Result();
        if(adminDailyGradService.delete(id)){
            result.setMsg("success");
            return result;
        }
        result.setMsg("error");
        return result;
    }




}
