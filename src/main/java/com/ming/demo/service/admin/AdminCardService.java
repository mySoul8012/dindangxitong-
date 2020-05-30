package com.ming.demo.service.admin;

import com.github.pagehelper.PageHelper;
import com.ming.demo.mapper.admin.AdminCardMapper;
import com.ming.demo.model.Card;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class AdminCardService {
    private AdminCardMapper adminCardMapper;

    // 查询
    public List<Card> findAllCard(int pageNo, int pageSIze) {
        PageHelper.startPage(pageNo, pageSIze);
        return adminCardMapper.findAllCard();
    }

    // 增加
    public boolean insertCard(Card card){
        if(adminCardMapper.insertCard(card) == 1){
            return true;
        }
        return false;
    }

    // 修改
    public boolean updateCard(Card card){
        if(adminCardMapper.updateCard(card) == 1){
            return true;
        }
        return false;
    }

    // 删除
    public boolean deleteUpdate(String id){
        if(adminCardMapper.deleteCard(id) == 1){
            return true;
        }
        return false;
    }



}
