package com.cskaoyan.promoteModule.couponManage.service;

import com.cskaoyan.promoteModule.couponManage.bean.Coupon;
import com.cskaoyan.promoteModule.couponManage.bean.ListBean;

public interface CouponService {
    ListBean queryCouponListBean(Integer page, Integer limit, String sort, String order);

    Coupon create(Coupon coupon);

    Coupon update(Coupon coupon);

    int delete(Coupon coupon);
}
