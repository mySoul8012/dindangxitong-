package com.ming.demo.service.index;

import com.ming.demo.bean.index.GoodsBean;
import com.ming.demo.mapper.ClassificationMapper;
import com.ming.demo.mapper.DailyGradMapper;
import com.ming.demo.mapper.GoodsMapper;
import com.ming.demo.model.Classification;
import com.ming.demo.model.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IndexService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private DailyGradMapper dailyGradMapper;

    @Autowired
    private ClassificationMapper classificationMapper;

    // 获取总分类
    public List<Classification> findAllMain(){
        return classificationMapper.findAllMain();
    }


    // 查询所有的商品
    public List<Goods> getAllGoods(){
        return goodsMapper.getAllGoods();
    }

    // 查询每日必抢
    public List<Goods> getMustDayGoods(){
        // 获取每日必抢商品id
        List<Integer> integerList = dailyGradMapper.getGoodsId();
        List<Goods> goodsList = new ArrayList<>();
        // 进行遍历
        // 添加计数
        int count = 0;
        for (Integer integer : integerList) {
            // 查询商品
            count++;
            Goods goods = goodsMapper.getGood(integer + "");
            goodsList.add(goods);
            if(count == 5){
                break;
            }
        }
        return goodsList;
    }

    public List<GoodsBean> getGoodsBean(){
        // 获取全部商品
        List<Goods> goodsList = goodsMapper.getAllGoods3();
        List<GoodsBean> goodsBeans = new ArrayList<>();
        // 进行遍历填充到分类
        for (Goods goods : goodsList) {
            GoodsBean goodsBean = new GoodsBean();
            // 添加相关的内容
            goodsBean.setId(goods.getId() + "");
            goodsBean.setTitle(goods.getName());
            goodsBean.setSubTitle(goods.getSubtitle());
            goodsBean.setCommodityPrice(goods.getCommodityPrice());
            goodsBean.setImgUrl(goods.getImgUrl());
            // 获取到分类id
            String category = goods.getClassification();
            // 根据分类id，查询相关的名称
            goodsBean.setCategorySubName(classificationMapper.findIdCategoryName(category));
            goodsBean.setCategoryName(classificationMapper.findIdCategoryName(category));
            goodsBeans.add(goodsBean);
        }
        return goodsBeans;
    }

    // 获取到首页商品四条数据。
    public List<Goods> CommodityBox(){
        return goodsMapper.getAllGoods4();
    }
}
