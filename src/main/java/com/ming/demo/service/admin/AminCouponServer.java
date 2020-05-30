package com.ming.demo.service.admin;

import com.github.pagehelper.PageHelper;
import com.ming.demo.mapper.admin.AdminCouponMapper;
import com.ming.demo.model.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AminCouponServer {
    @Autowired
    private AdminCouponMapper adminCouponMapper;

    // 增加
    public boolean insertCoupon(Coupon coupon){
        if(adminCouponMapper.insertIntoCoupon(coupon) == 1){
            return true;
        }
        return false;
    }


    public List<Coupon> findAllCoupon(int pageNo, int pageSize){
        PageHelper.startPage(pageNo, pageSize);
        return adminCouponMapper.findAllCoupon();
    }

    public boolean deleteCoupon(String id){
        if(adminCouponMapper.deleteCoupon(id) == 1){
            return true;
        }
        return false;
    }

    public boolean updateCoupon(Coupon coupon){
        if(adminCouponMapper.updateCoupon(coupon) == 1){
            return true;
        }

        return false;
    }


}
