package com.ming.demo.bean.evaluation;

import java.util.HashMap;

// 评论Map
public class EvaluationCountBean {
    private HashMap<String, Integer> evaluationMapCount = new HashMap<>();

    public HashMap<String, Integer> getEvaluationMapCount() {
        return evaluationMapCount;
    }

    public void setEvaluationMapCount(HashMap<String, Integer> evaluationMapCount) {
        this.evaluationMapCount = evaluationMapCount;
    }
}
