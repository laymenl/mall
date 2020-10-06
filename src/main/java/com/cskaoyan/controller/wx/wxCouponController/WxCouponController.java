package com.cskaoyan.controller.wx.wxCouponController;

import com.cskaoyan.promoteModule.couponManage.bean.BaseRespVo;
import com.cskaoyan.wx_feedBack_footPrint_coupon_pic.couponManage.bean.ListBean;
import com.cskaoyan.wx_feedBack_footPrint_coupon_pic.couponManage.bean.WxCouponBo;
import com.cskaoyan.wx_feedBack_footPrint_coupon_pic.couponManage.bean.WxCouponCodeBo;
import com.cskaoyan.wx_feedBack_footPrint_coupon_pic.couponManage.service.WxCouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("wx/coupon")
public class WxCouponController {

    @Autowired
    WxCouponService couponService;

    /*
        参数 page=1&limit=20&sort=add_time&order=desc
                page=1&size=10
    * */
    @RequestMapping("list")
    public BaseRespVo list(Integer page, Integer size) {
        ListBean listBean = couponService.queryCouponListBean(page, size);
        return BaseRespVo.ok(listBean);
    }

    // status=0&page=1&size=10
    @RequestMapping("mylist")
    public BaseRespVo list(Short status, Integer page, Integer size) {
        ListBean listBean = couponService.queryMyCouponListBean(status, page, size);
        return BaseRespVo.ok(listBean);
    }

    //cartId=36&grouponRulesId=10
    @RequestMapping("selectlist")
    public BaseRespVo selectlist(Integer cardId, Integer grouponRulesId) {
        List couponList = couponService.queryCouponSelectListBean(cardId, grouponRulesId);
        return BaseRespVo.ok(couponList);
    }

    //couponId: 26  post
    @RequestMapping("receive")
    public BaseRespVo receive(@RequestBody WxCouponBo wxCouponBo) {
        int receiveStatus = couponService.receive(wxCouponBo.getCouponId());
        return receiveStatus == 1 ? BaseRespVo.ok() : BaseRespVo.fail("maybe already received");
    }

    // code: "DC6FF8SE"
    @RequestMapping("exchange")
    public BaseRespVo exchange(@RequestBody WxCouponCodeBo wxCouponCodeBo) {
        int receiveStatus = couponService.exchange(wxCouponCodeBo.getCode());
        return receiveStatus == 1 ? BaseRespVo.ok() : BaseRespVo.fail("maybe already exchanged");
    }

}

