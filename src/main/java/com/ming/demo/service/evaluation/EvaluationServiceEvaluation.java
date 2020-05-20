package com.ming.demo.service.evaluation;

import com.ming.demo.bean.evaluation.EvaluationCountBean;
import com.ming.demo.bean.evaluation.EvaluationListBean;
import com.ming.demo.mapper.UserMapper;
import com.ming.demo.mapper.evaluation.EvaluationMapperEvaluation;
import com.ming.demo.model.Evaluation;
import com.ming.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class EvaluationServiceEvaluation {

    @Autowired
    private EvaluationMapperEvaluation evaluationMapperEvaluation;

    @Autowired
    private UserMapper userMapper;

    // 获取评论Map 好评，对应的数量
    public EvaluationCountBean evaluationCountBean(String id){
        // 根据id，查询Evaluation
        List<Evaluation> evaluationList = evaluationMapperEvaluation.evaluationList(id);
        HashMap<String, Integer> hashMap = new HashMap<>();
        // 进行查询判断
        for (Evaluation evaluation : evaluationList) {
            // 获取分类
            String category = evaluation.getCategory();
            hashMap.put("好评", 0);
            hashMap.put("中评", 0);
            hashMap.put("差评", 0);
            hashMap.put("有图", 0);
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

    // 分类  sort
    // 全部 1
    // 好评 2
    // 中评 3
    // 差评 4
    // 是否 有图
    // 页数 pageNo
    // 页面条数 size
    public List<EvaluationListBean> evaluationListBean(String id, String sort, String isImg, int pageNo, int size){
        // 跳过几行
        int skipLine = pageNo * size;
        // 选择前size行的
        int firstLine = (pageNo+1) * size;
        // 获取商品
        // 根据商品id，查询相关的商品评论bean
        List<EvaluationListBean> listBeans = new ArrayList<>();
        // 获取列表List。
        // 如果sort是2
            List<Evaluation> evaluationList = evaluationMapperEvaluation.evaluationList01(id, sort, isImg, skipLine, firstLine);
        // 获取列表List
        for (Evaluation evaluation : evaluationList) {
            // 获取列表List
            EvaluationListBean evaluationListBean = new EvaluationListBean();
            // 进行添加
            evaluationListBean.setId(evaluation.getId());
            evaluationListBean.setTime(evaluation.getTime());
            evaluationListBean.setDetails(evaluation.getDetails());
            evaluationListBean.setStar(evaluation.getStar());
            // 获取用户id
            String userId = evaluation.getUserId();
            // 获取对象
            User user = userMapper.getIdUser(userId);
            // 进行设置
            evaluationListBean.setImgUrl(user.getImgUrl());
            evaluationListBean.setIsItVip(user.getIsItVip());
            evaluationListBean.setUserName(user.getName());
            listBeans.add(evaluationListBean);
        }
        return listBeans;
    }
}
