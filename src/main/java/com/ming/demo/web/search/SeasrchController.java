package com.ming.demo.web.search;

import com.ming.demo.model.Goods;
import com.ming.demo.service.search.SearchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
@Api(tags = "搜索类")
public class SeasrchController {
    @Autowired
    private SearchService searchService;


    // 搜索关键字
    // sort 综合排序 传入 1 默认
    // 销量 传入 2
    // 价格 传入 3 从高到低
    // 价格 传入 4 从低到高
    // 最高价 highestPrice 默认 0 不筛选
    // 最低价 lowestPrice 默认 0 不筛选
    // 服务类型 merchantServices  默认 0 不筛选  上门 1  到店 2
    // 所属分类  category 默认 0  不筛选 否则传入分类id
    // 页数 pageNo
    // 页面数据大小 size
    @ApiOperation("搜索列表")
    @RequestMapping(value = "/searchList")
    public List<Goods> searchList(@ApiParam("关键字") String keyWorld,
                                  @ApiParam("排序 1综合  2销量  3价格从高到低  4价格从低到高")@RequestParam(defaultValue = "1") String Sort,
                                  @ApiParam("最高价")@RequestParam(defaultValue = "10000000000000000000000") String highestPrice,
                                  @ApiParam("最低价")@RequestParam(defaultValue = "0")String lowestPrice,
                                  @ApiParam("服务类型  1到家  2到店")@RequestParam(defaultValue = "0")String merchantServices,
                                  @ApiParam("所属分类")@RequestParam(defaultValue = "0")String category,
                                  @ApiParam("页数")@RequestParam(defaultValue = "0")String pageNo,
                                  @ApiParam("页面条数")@RequestParam(defaultValue = "5")String size){
        return searchService.searchKeyWorldList(keyWorld, Sort, highestPrice, lowestPrice, merchantServices, category, pageNo,size);
    }
}
