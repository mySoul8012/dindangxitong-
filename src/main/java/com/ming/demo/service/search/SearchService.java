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
    // 销量 传入 2 从高到低
    // 销量 传入 3 从低到高
    // 价格 传入 4 从高到低
    // 价格 传入 5 从低到高
    // 最高价 highestPrice 默认 100000 不筛选
    // 最低价 lowestPrice 默认 0 不筛选
    // 服务类型 merchantServices  默认 0 不筛选  上门 1  到店 2
    // 所属分类 category 默认 0  不筛选 否则传入分类id
    // 页数 pageNo
    // 页面数据大小 size
    public List<Goods> searchKeyWorldList(String keyWorld,
                                          String Sort,
                                           String highestPrice,
                                          String lowestPrice,
                                          String merchantServices,
                                          String category,
                                          String pageNo,
                                          String size){
        // 进行搜索
        int previous = Integer.parseInt(pageNo) * Integer.parseInt(size);
        int next = Integer.parseInt(size);
        return searchMapper.searchListTwoVersion(keyWorld, Sort,highestPrice, lowestPrice, merchantServices, category, previous, next);
    }
}
