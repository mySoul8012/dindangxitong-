package com.ming.demo.web;

import com.ming.demo.bean.GoodsBean;
import com.ming.demo.service.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Deprecated
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    // 根据id获取商品
    @ApiOperation("根据id获取商品展示")
    @GetMapping("/getGoods")
    public GoodsBean getGoodsBean(String id){
        // 根据id获取商品
        if(id == null){
            return null;
        }
        // 根据id获取商品
        return goodsService.getGoods(id);
    }
}
