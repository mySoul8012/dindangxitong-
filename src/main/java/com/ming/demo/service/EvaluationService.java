package com.ming.demo.service;

import com.ming.demo.mapper.EvaluationMapper;
import com.ming.demo.model.Evaluation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluationService {

    @Autowired
    private EvaluationMapper evaluationMapper;


    public List<Evaluation> evaluationList(String id){
        return evaluationMapper.evaluation(id);
    }
}
