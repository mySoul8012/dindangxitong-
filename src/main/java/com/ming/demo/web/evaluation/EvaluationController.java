package com.ming.demo.web.evaluation;

import com.ming.demo.bean.evaluation.EvaluationCountBean;
import com.ming.demo.service.evaluation.EvaluationServiceEvaluation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 评价控制器
@RestController
@RequestMapping("/evaluation")
public class EvaluationController {

    @Autowired
    private EvaluationServiceEvaluation evaluationServiceEvaluation;


    // 数量
    @RequestMapping("/evaluationCount")
    public EvaluationCountBean evaluationCount(String id){
        return evaluationServiceEvaluation.evaluationCountBean(id);
    }
}
