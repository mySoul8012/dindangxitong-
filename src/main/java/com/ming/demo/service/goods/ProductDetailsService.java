package com.ming.demo.service.goods;

import com.ming.demo.bean.goods.GoodsIndexBean;
import com.ming.demo.bean.goods.Valuation;
import com.ming.demo.mapper.goods.EvaluationMapperGoods;
import com.ming.demo.mapper.goods.GoodsMapperGoods;
import com.ming.demo.mapper.goods.UserMapperUser;
import com.ming.demo.mapper.shop.ShopMapper;
import com.ming.demo.model.Evaluation;
import com.ming.demo.model.Goods;
import com.ming.demo.model.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// 商品详情页内容
@Service
public class ProductDetailsService {

    @Autowired
    private GoodsMapperGoods goodsMapperGoods;

    @Autowired
    private EvaluationMapperGoods evaluationMapperGoods;

    @Autowired
    private UserMapperUser userMapperUser;

    @Autowired
    private ShopMapper shopMapper;

    // 获取商品详情页 传入id
    public GoodsIndexBean getGoodsIndexBean(String id){
        // 获取商品详情
        // 获取商品
        Goods goods = goodsMapperGoods.getGood(id);
        // 获取评价列表
        List<Evaluation> evaluationList = evaluationMapperGoods.evaluations(id);
        // 进行转化
        GoodsIndexBean goodsIndexBean = new GoodsIndexBean();
        // 进行转化
        goodsIndexBean.setId(id);
        goodsIndexBean.setCommodityPrice(goods.getCommodityPrice());
        goodsIndexBean.setDiscountPrice(goods.getDiscountPrice());
        goodsIndexBean.setName(goods.getName());
        goodsIndexBean.setSubTitle(goods.getSubtitle());
        goodsIndexBean.setSales(goods.getSales());
        goodsIndexBean.setDetails(goods.getDetails());
        goodsIndexBean.setCountValuation(evaluationList.size() + "");
        goodsIndexBean.setImgUrl(goods.getImgUrl());
        // 获取前三条评价
        List<Valuation> valuationList = new ArrayList<>();
        // 进行遍历
        for (int i = 0; i < 3; i++) {
            // 遍历3次
            Valuation valuation = new Valuation();
            // 添加相关信息
            // 获取当前评价对象
            Evaluation evaluation = new Evaluation();
            try {
                evaluation = evaluationList.get(i);
            }catch(Exception e){
                break;
            }
            // 获取用户id
            String userId = evaluation.getUserId();
            // 获取用户名称
            String name = userMapperUser.getUser(userId).getName();
            valuation.setName(name);
            // 是否是VIP
            valuation.setIsItVip(userMapperUser.getUser(userId).getIsItVip());
            // 用户评价星级
            valuation.setStar(evaluation.getStar());
            valuation.setTime(evaluation.getTime());
            valuation.setDetails(evaluation.getDetails());
            valuation.setImgUrl(userMapperUser.getUser(userId).getImgUrl());
            valuationList.add(valuation);
        }
        goodsIndexBean.setValuations(valuationList);
        // 获取商家信息
        String bussicns = goods.getBusiness();
        Shop shop = shopMapper.getShopId(bussicns);
        goodsIndexBean.setShop(shop);
        return goodsIndexBean;
    }
}
