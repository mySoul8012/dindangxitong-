package com.ming.demo.web.goods;

import com.ming.demo.model.Classification;
import com.ming.demo.model.Goods;
import com.ming.demo.service.goods.GoodsListServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// 首页列表，控制器
@RestController
@RequestMapping("/goods")
public class GoodsListController {
    @Autowired
    private GoodsListServer goodsListServer;

    @Autowired
    private GoodsListServer goodsListServer1;


    // 子分类查询
    @RequestMapping("/parentCategoryFind")
    public List<Classification> parentCategoryFind(String classIfication){
        // 查询子分类
        return goodsListServer.findParentCategory(classIfication);
    }

    // 子分类商品查询
    @RequestMapping("/subcategories")
    public List<Goods> subcategories(String classification){
        // 商品所属分类
        return goodsListServer1.findAllGoods(classification);
    }
}
