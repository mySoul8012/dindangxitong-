package com.ming.demo.service.admin;

import com.github.pagehelper.PageHelper;
import com.ming.demo.mapper.admin.AdminGoodsMapper;
import com.ming.demo.model.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminGoodsServer {
    @Autowired
    private AdminGoodsMapper adminGoodsMapper;


    public List<Goods> getListGoods(int pageNo, int size) {
        PageHelper.startPage(pageNo, size);
        return adminGoodsMapper.getListGoods();
    }

    public int insertGoods(Goods goods) {
        // 添加goods
        return adminGoodsMapper.insertGoods(goods);
    }

    public int deleteGoods(String id) {
        return adminGoodsMapper.deleteGoods(id);
    }

    public int updateGoods(Goods goods) {
        return adminGoodsMapper.updateGoods(goods);
    }
}
