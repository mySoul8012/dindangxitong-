package com.ming.demo.web.admin;

import com.ming.demo.bean.Result;
import com.ming.demo.model.Coupon;
import com.ming.demo.model.Goods;
import com.ming.demo.service.admin.AminCouponServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/coupon")
public class AdminCouponController {
    @Autowired
    private AminCouponServer aminCouponServer;

    @RequestMapping("/couponList")
    public List<Coupon> couponList(int pageNo, int pageSize){
        return aminCouponServer.findAllCoupon(pageNo, pageSize);
    }

    // 增加
    @RequestMapping("/insertCoupon")
    public Result insertCoupon(Coupon coupon){
        Result result = null;
        if(aminCouponServer.insertCoupon(coupon)){
            result = new Result();
            result.setMsg("success");
        }else{
            result = new Result();
            result.setMsg("error");
        }
        return result;
    }


    @RequestMapping("/deleteCoupon")
    public Result deleteCoupon(String id){
        Result result = null;
        if(aminCouponServer.deleteCoupon(id)){
            result = new Result();
            result.setMsg("success");
        }else{
            result = new Result();
            result.setMsg("error");
        }
        return result;
    }

    @RequestMapping("/update")
    public Result updateCoupon(Coupon coupon){
        if(aminCouponServer.updateCoupon(coupon)){
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
