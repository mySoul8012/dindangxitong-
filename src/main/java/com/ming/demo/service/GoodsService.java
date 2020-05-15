package com.ming.demo.service;

import com.ming.demo.bean.EvaluationBean;
import com.ming.demo.bean.GoodsBean;
import com.ming.demo.mapper.ClassificationMapper;
import com.ming.demo.mapper.GoodsMapper;
import com.ming.demo.mapper.OrderMapper;
import com.ming.demo.mapper.UserMapper;
import com.ming.demo.model.Evaluation;
import com.ming.demo.model.Goods;
import com.ming.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private OrderMapper orderMapper;


    @Autowired
    private ClassificationMapper classificationMapper;

    @Autowired
    private EvaluationService evaluationService;

    @Autowired
    private UserMapper userMapper;


    // 根据商品id获取商品GoodsBean
    public GoodsBean getGoods(String id){
        // 进行非空判断
        if(id == null){
            return null;
        }
        // 获取商品Goods
        Goods goods = goodsMapper.getGood(id);
        // 进行转化
        GoodsBean goodsBean = new GoodsBean();
        // 添加相关数据
        goodsBean.setTitle(goods.getName());
        goodsBean.setSubTitle(goods.getSubtitle());
        goodsBean.setCommodityPrice(goods.getCommodityPrice());;
        goodsBean.setImgUrl(goods.getImgUrl());
        // 获取分类相关信息
        String categoryId = goods.getClassification();
        // 获取商品的分类名称
        goodsBean.setCategoryName(classificationMapper.findIdCategoryName(categoryId));
        // 获取商品备注
        goodsBean.setCategoryNotes(classificationMapper.findIdCategoryNotes(categoryId));
        // 评价列表
        String idString = goods.getId() + "";
        List<Evaluation> evaluationList = evaluationService.evaluationList(idString);
        List<EvaluationBean> evaluationBeans = new ArrayList<EvaluationBean>();
        // 进行转化
        for (Evaluation evaluation : evaluationList) {
            EvaluationBean evaluationBean = new EvaluationBean();
            // 添加数据
            evaluationBean.setId(evaluation.getId());
            // 查询用户头像
            evaluationBean.setUserImgUrl(userMapper.getIdImgUrl(evaluation.getId() + ""));
            User user = userMapper.getIdUser(evaluation.getId() + "");
            // 获取用户名称。
            evaluationBean.setUserName(user.getName());
            // 评价星级
            evaluationBean.setStarRating(evaluation.getStar());
            // 评价标签
            evaluationBean.setLabel(evaluation.getLabel());
            // 评价详情
            evaluationBean.setDetails(evaluation.getDetails());
            // 评价时间
            evaluationBean.setTime(evaluation.getTime());
            evaluationBeans.add(evaluationBean);
        }
        goodsBean.setEvaluationBeanList(evaluationBeans);
        return goodsBean;
    }
}
