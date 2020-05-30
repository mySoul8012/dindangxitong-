package com.ming.demo.web.admin;

import com.ming.demo.bean.Result;
import com.ming.demo.model.Admin;
import com.ming.demo.model.Evaluation;
import com.ming.demo.service.EvaluationService;
import com.ming.demo.service.admin.AdminEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/evaluation")
public class AdminEvaluationController {
    @Autowired
    private AdminEvaluationService adminEvaluationService;

    // 增
    @RequestMapping("/addEvaluation")
    public Result addEvaluation(Evaluation evaluation){
        Result reuslt = new Result();
        if(adminEvaluationService.addEvaluation(evaluation)){
            reuslt.setMsg("success");
            return reuslt;
        }
        reuslt.setMsg("errror");
        return reuslt;

    }

    // 删
    @RequestMapping("/deleteEvaluation")
    public Result deleteEvaluation(String id){
        Result result = new Result();
        if(adminEvaluationService.deleteEvaluation(id)){
            result.setMsg("succss");
            return result;
        }
        result.setMsg("error");
        return result;
    }

    // 查询
    @RequestMapping("/findAllEvaluation")
    public List<Evaluation> findAllEvaluation(int pageNo, int pageSize){
        return adminEvaluationService.findEvaluation(pageNo, pageSize);
    }

    // 改
    @RequestMapping("/updateEvaluation")
    public Result updateEvaluation(Evaluation evaluation){
        Result result = new Result();
        if(adminEvaluationService.updateEvaluation(evaluation)){
            result.setMsg("success");
            return result;
        }
        result.setMsg("error");
        return result;
    }
}
