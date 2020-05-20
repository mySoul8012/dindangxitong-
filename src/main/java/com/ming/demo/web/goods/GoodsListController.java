package com.ming.demo.web.goods;

import com.ming.demo.bean.goods.GoodsIndexBean;
import com.ming.demo.model.Classification;
import com.ming.demo.model.Goods;
import com.ming.demo.service.goods.GoodsListServer;
import com.ming.demo.service.goods.ProductDetailsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// 首页列表，控制器
@RestController
@RequestMapping("/goods")
@Api(tags = "商品类")
public class GoodsListController {
    @Autowired
    private GoodsListServer goodsListServer;

    @Autowired
    private GoodsListServer goodsListServer1;

    @Autowired
    private ProductDetailsService productDetailsService;

    // 子分类查询
    @ApiOperation("子分类查询")
    @RequestMapping("/parentCategoryFind")
    public List<Classification> parentCategoryFind(String classIfication){
        // 查询子分类
        return goodsListServer.findParentCategory(classIfication);
    }

    // 子分类商品查询
    @ApiOperation("子分类商品查询")
    @RequestMapping("/subcategories")
    public List<Goods> subcategories(String classification){
        // 商品所属分类
        return goodsListServer1.findAllGoods(classification);
    }

    // 商品详情页页面信息
    @ApiOperation("商品详情页页面信息")
    @RequestMapping("/goodsIndexBeans")
    public GoodsIndexBean goodsIndexBeans(@RequestParam(defaultValue = "1") String id){
        // 根据id查询商品详情页页面信息
        return productDetailsService.getGoodsIndexBean(id);
    }

    @RequestMapping("/goodsIndexBeans1")
    @ApiOperation("商品详情页页面信息")
    public GoodsIndexBean goodsIndexBeans1(@RequestParam(defaultValue = "1") String id){
        // 根据id查询商品详情页页面信息
        return productDetailsService.getGoodsIndexBean(id);
    }
}
