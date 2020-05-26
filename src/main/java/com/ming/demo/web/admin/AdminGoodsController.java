package com.ming.demo.web.admin;

import com.ming.demo.bean.Result;
import com.ming.demo.model.Goods;
import com.ming.demo.service.admin.AdminGoodsServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.print.attribute.ResolutionSyntax;
import java.util.List;

// 商品管理界面的增删查改
@RestController
@RequestMapping("/admin")
public class AdminGoodsController {
    @Autowired
    private AdminGoodsServer adminGoodsServer;

    // 查询
    @RequestMapping("/getGoodsList")
    public List<Goods> getListGoods(int pageNo, int size){
        return adminGoodsServer.getListGoods(pageNo, size);
    }

    // 增加
    @RequestMapping("/insertGoods")
    public Result insertGoods(Goods goods){
        // 增加商品
        int resLine = adminGoodsServer.insertGoods(goods);
        Result result = null;
        if(resLine == 1){
            result = new Result();
            result.setMsg("success");
        }else{
            result = new Result();
            result.setMsg("error");
        }
        return result;
    }


    // 删除
    @RequestMapping("/deleteGoods")
    public Result deleteGoods(String id){
        // 删除商品
        int res = adminGoodsServer.deleteGoods(id);
        Result result = null;
        if(res == 1){
            result = new Result();
            result.setMsg("success");
        }else{
            result = new Result();
            result.setMsg("error");
        }
        return result;
    }


    // 更改
    @RequestMapping("/update")
    public Result updateGoods(Goods goods){
        int res = adminGoodsServer.updateGoods(goods);
        if(res == 1){
            Result result = new Result();
            result.setMsg("success");
            return result;
        }else{
            Result result = new Result();
            result.setMsg("error");
            return result;
        }
    }
}
