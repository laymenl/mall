package com.cskaoyan.wx_feedBack_footPrint_coupon_pic.couponManage.service;

import com.cskaoyan.promoteModule.couponManage.bean.Coupon;
import com.cskaoyan.wx_feedBack_footPrint_coupon_pic.couponManage.bean.ListBean;

import java.util.List;

public interface WxCouponService {
    ListBean queryCouponListBean(Integer page, Integer size);

    ListBean queryMyCouponListBean(Short status, Integer page, Integer size);

    List queryCouponSelectListBean(Integer cardId, Integer grouponRulesId);

    int receive(Integer couponId);

    int exchange(String code);
}
