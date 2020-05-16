package com.ming.demo.service.goods;

import com.ming.demo.mapper.ClassificationMapper;
import com.ming.demo.mapper.goods.GoodsMapperGoods;
import com.ming.demo.model.Classification;
import com.ming.demo.model.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsListServer {
    @Autowired
    private ClassificationMapper classificationMapper;

    @Autowired
    private GoodsMapperGoods goodsMapperGoods;

    public List<Classification> findParentCategory(String classIfication){
        // mapper查询子分类列表
        return classificationMapper.findClassification(classIfication);
    }

    public List<Goods> findAllGoods(String classification){
        // 查询子列表
        return goodsMapperGoods.subcategories(classification);
    }
}
