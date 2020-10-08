package com.cskaoyan.service.wx;

import com.cskaoyan.bean.wxvo.cart.*;

public interface WxCartService {
    CartListBean index(String username);

    void update(Cart cart);

    CartListBean checked(CartBO cartBO, String username);

    CartListBean delete(CartBO cartBO, String username);

    CheckoutVO checkout(String username, Integer cartId, Integer addressId, Integer couponId, Integer grouponRulesId);

    Integer goodscount(String username);

    int add(AddBO addBO, String username);

    int fastadd(AddBO addBO, String username);
}
