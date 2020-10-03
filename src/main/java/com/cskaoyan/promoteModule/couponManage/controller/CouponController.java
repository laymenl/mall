package com.cskaoyan.promoteModule.couponManage.controller;

import com.cskaoyan.promoteModule.couponManage.bean.BaseRespVo;
import com.cskaoyan.promoteModule.couponManage.bean.Coupon;
import com.cskaoyan.promoteModule.couponManage.bean.ListBean;
import com.cskaoyan.promoteModule.couponManage.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin/coupon")
public class CouponController {

    @Autowired
    CouponService couponService;

    /*
        参数 page=1&limit=20&sort=add_time&order=desc
    * */
    @RequestMapping("list")
    public BaseRespVo list(Integer page, Integer limit, String sort, String order) {
        ListBean listBean = couponService.queryCouponListBean(page, limit, sort, order);
        return BaseRespVo.ok(listBean);
    }

    @RequestMapping("create")
    public BaseRespVo create(@RequestBody Coupon coupon) {
        Coupon couponInfo= couponService.create(coupon);
        return BaseRespVo.ok(couponInfo);
    }


    @RequestMapping("update")
    public BaseRespVo update(@RequestBody Coupon coupon){
        Coupon couponInfo = couponService.update(coupon);
        return BaseRespVo.ok(couponInfo);
    }


    @RequestMapping("delete")
    public BaseRespVo delete(@RequestBody Coupon coupon){
        int status = couponService.delete(coupon);
        return status == 1?BaseRespVo.ok():BaseRespVo.fail("delete error");
    }
}

