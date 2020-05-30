package com.ming.demo.service.admin;

import com.github.pagehelper.PageHelper;
import com.ming.demo.mapper.admin.AdminEvaluationMapper;
import com.ming.demo.model.Evaluation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminEvaluationService {
    @Autowired
    private AdminEvaluationMapper adminEvaluationMapper;
    // 增
    public boolean addEvaluation(Evaluation evaluation){
        int res = adminEvaluationMapper.insertEValuation(evaluation);
        if(res == 1){
            return true;
        }
        return false;
    }

    // 删
    public boolean deleteEvaluation(String id){
        int res = adminEvaluationMapper.deleteEvaluation(id);
        if(res == 1){
            return true;
        }
        return false;
    }

    // 查
    public List<Evaluation> findEvaluation(int pageNo, int pageSize){
        PageHelper.startPage(pageNo, pageSize);
        return adminEvaluationMapper.getList();
    }

    // 改
    public boolean updateEvaluation(Evaluation evaluation){
        int res = adminEvaluationMapper.updateEvaluation(evaluation);
        if(res == 1){
            return true;
        }
        return false;
    }

}
