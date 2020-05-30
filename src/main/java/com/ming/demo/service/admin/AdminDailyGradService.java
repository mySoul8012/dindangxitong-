package com.ming.demo.service.admin;

import com.github.pagehelper.PageHelper;
import com.ming.demo.mapper.admin.AdminDailyGradMapper;
import com.ming.demo.model.DailyGrab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminDailyGradService {
        @Autowired
        private AdminDailyGradMapper adminDailyGradMapper;

        // 增加
        public boolean insert(DailyGrab dailyGrab){
            int res = adminDailyGradMapper.insertAllDailyGrad(dailyGrab.getGoodsId() + "");
            if(res == 1){
                return true;
            }
            return false;

        }

        // 修改
        public boolean update(DailyGrab dailyGrab){
            int res = adminDailyGradMapper.updateDailyGrad(dailyGrab);
            if(res == 1){
                return true;
            }
            return false;
        }

        // 删除
        public boolean delete(String id){
            int res = adminDailyGradMapper.deleteDailyGrad(id);
            if(res == 1){
                return true;
            }
            return false;
        }

        // 查询
        public List<DailyGrab> findAll(int pageNo, int pageSize){
            PageHelper.startPage(pageNo, pageSize);
            return adminDailyGradMapper.findAllDailyGrad();
        }
}
