package com.ming.demo.web.admin;

import com.ming.demo.bean.Result;
import com.ming.demo.model.Classification;
import com.ming.demo.service.admin.AdminClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/classification")
public class AdminClassificationController {
    @Autowired
    private AdminClassificationService adminClassificationService;

    @RequestMapping("/classifications")
    public List<Classification> classifications(int pageNo, int size){
        return adminClassificationService.findAllClassIfication(pageNo, size);
    }

    @RequestMapping("/insertclasssIfication")
    public Result insertClassification(Classification classification){
        Result result = new Result();
        if(adminClassificationService.insertClassIfication(classification)){
            result.setMsg("success");
            return result;
        }
        result.setMsg("error");
        return result;
    }


    @RequestMapping("/deleteClassIfication")
    public Result deleteClassIfication(String id){
        Result result = new Result();
        // 进行删除
        if(adminClassificationService.deleteClassIfication(id)){
            result.setMsg("success");
            return result;
        }
        result.setMsg("error");
        return  result;
    }

    // 进行修改
    @RequestMapping("/updateClassIfication")
    public Result updateClassIfication(Classification classification){
        Result result = new Result();
        // 进行修改
        if(adminClassificationService.updateClassIfication(classification)){
            result.setMsg("success");
            return result;
        }
        result.setMsg("error");
        return result;
    }


}
