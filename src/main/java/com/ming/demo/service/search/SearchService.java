package com.ming.demo.service.search;

import com.ming.demo.mapper.search.SearchMapper;
import com.ming.demo.model.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class SearchService {
    @Autowired
    private SearchMapper searchMapper;

    // 搜索关键字
    // sort 综合排序 传入 1 默认
    // 销量 传入 2
    // 价格 传入 3 从高到低
    // 价格 传入 4 从低到高
    // 最高价 highestPrice 默认 0 不筛选
    // 最低价 lowestPrice 默认 0 不筛选
    // 服务类型 merchantServices  默认 0 不筛选  上门 1  到店 2
    // 所属分类  category 默认 0  不筛选 否则传入分类id
    public List<Goods> searchKeyWorldList(String keyWorld,
                                          @RequestParam(defaultValue = "1") String Sort,
                                          @RequestParam(defaultValue = "0") String highestPrice,
                                          @RequestParam(defaultValue = "0")String lowestPrice,
                                          @RequestParam("0")String merchantServices,
                                          @RequestParam("0")String category){
        // 进行搜索
        return searchMapper.searchList(keyWorld);
    }
}
