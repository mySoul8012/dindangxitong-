package com.ming.demo.service.evaluation;

import com.ming.demo.bean.evaluation.EvaluationCountBean;
import com.ming.demo.mapper.evaluation.EvaluationMapperEvaluation;
import com.ming.demo.model.Evaluation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class EvaluationServiceEvaluation {

    @Autowired
    private EvaluationMapperEvaluation evaluationMapperEvaluation;

    // 获取评论Map 好评，对应的数量
    public EvaluationCountBean evaluationCountBean(String id){
        // 根据id，查询Evaluation
        List<Evaluation> evaluationList = evaluationMapperEvaluation.evaluationList(id);
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("好评", 0);
        hashMap.put("中评", 0);
        hashMap.put("差评", 0);
        hashMap.put("有图", 0);
        // 进行查询判断
        for (Evaluation evaluation : evaluationList) {
            // 获取分类
            String category = evaluation.getCategory();

            // 进行分类获取
            if(category.equals("1")){
                hashMap.put("好评", (hashMap.get("好评") + 1));
            }
            if(category.equals("2")){
                hashMap.put("中评", (hashMap.get("中评") + 1));
            }
            if(category.equals("3")){
                hashMap.put("差评", (hashMap.get("差评") + 1));
            }
            if(evaluation.getIsImg().equals("1")){
                // 有图
                hashMap.put("有图", (hashMap.get("有图") + 1));
            }
        }
        EvaluationCountBean evaluationCountBean = new EvaluationCountBean();
        evaluationCountBean.setEvaluationMapCount(hashMap);
        return evaluationCountBean;
    }
}
