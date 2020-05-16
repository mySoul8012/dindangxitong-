package com.ming.demo.web.index;

import com.ming.demo.bean.Result;
import com.ming.demo.bean.index.GoodsBean;
import com.ming.demo.mapper.GoodsMapper;
import com.ming.demo.model.Classification;
import com.ming.demo.model.Goods;
import com.ming.demo.service.index.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/index")
//首页商品
public class IndexController {

    @Autowired
    private IndexService indexService;

    // 获取总分类
    @RequestMapping("/findAllMain")
    public List<Classification> findAllMain(){
        return indexService.findAllMain();
    }


    @RequestMapping("/goods")
    // 获取全部商品
    public List<Goods> result(){
        return indexService.getAllGoods();
    }

    // 查询每日必抢
    @RequestMapping("/mustGoods")
    public List<Goods> findAllGetGoods(){
        // 查询每日必抢
        return indexService.getMustDayGoods();
    }

    // 商品卡片
    @RequestMapping("/goodsCard")
    public List<GoodsBean> getGoodsCard(){
        // 获取全部商品
        List<GoodsBean> goodsBean = indexService.getGoodsBean();
        return goodsBean;
    }

    // 首页第二个商品方块
    @RequestMapping("/commodityBox")
    public List<Goods> commodityBox(){
        return indexService.CommodityBox();
    }

}
