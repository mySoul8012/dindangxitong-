package com.ming.demo.web.admin;

import com.ming.demo.bean.Result;
import com.ming.demo.model.Card;
import com.ming.demo.service.admin.AdminCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// 卡 增删查改
@RestController
@RequestMapping("/admin/card")
public class AdminCardController {
    @Autowired
    private AdminCardService adminCardService;


    // 查询
    @RequestMapping("/findAllCard")
    public List<Card> findAllcard(int pageNo, int pageSIze){
        return adminCardService.findAllCard(pageNo, pageSIze);
    }

    // 增加
    @RequestMapping("/insertCard")
    public Result insertCard(Card card){
        // 进行增加
        Result result = new Result();
        if(adminCardService.insertCard(card)){
            result.setMsg("success");
            return result;
        }
        result.setMsg("error");
        return result;
    }

    // 修改
    @RequestMapping("/updateCard")
    public Result updateCard(Card card){
        Result result = new Result();
        // 添加相关的卡包
        if(adminCardService.insertCard(card)){
            result.setMsg("success");
            return result;
        }
        result.setMsg("error");
        return result;
    }

    // 删除
    @RequestMapping("/deleteCard")
    public Result deleteCard(String id){
        Result result = new Result();
        // 进行相关的删除
        if(adminCardService.deleteUpdate(id)){
            result.setMsg("success");
            return result;
        }
        result.setMsg("error");
        return result;
    }
}
