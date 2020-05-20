package com.ming.demo.web.search;

import com.ming.demo.model.Goods;
import com.ming.demo.service.search.SearchService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
@ApiOperation("搜索类")
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
    @RequestMapping("/searchList")
    public List<Goods> searchList(String keyWorld,
                                  @RequestParam(defaultValue = "1") String Sort,
                                  @RequestParam(defaultValue = "10000000000000000000000") String highestPrice,
                                  @RequestParam(defaultValue = "0")String lowestPrice,
                                  @RequestParam(defaultValue = "0")String merchantServices,
                                  @RequestParam(defaultValue = "0")String category,
                                  @RequestParam(defaultValue = "0")String pageNo,
                                  @RequestParam(defaultValue = "5")String size){
        return searchService.searchKeyWorldList(keyWorld, Sort, highestPrice, lowestPrice, merchantServices, category, pageNo,size);
    }
}
