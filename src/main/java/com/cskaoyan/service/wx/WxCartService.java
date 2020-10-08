package com.cskaoyan.service.wx;

import com.cskaoyan.bean.wxvo.cart.Cart;
import com.cskaoyan.bean.wxvo.cart.CartBO;
import com.cskaoyan.bean.wxvo.cart.CartListBean;
import com.cskaoyan.bean.wxvo.cart.CheckoutVO;

public interface WxCartService {
    CartListBean index(String username);

    void update(Cart cart);

    CartListBean checked(CartBO cartBO, String username);

    CartListBean delete(CartBO cartBO, String username);

    CheckoutVO checkout(String username, Integer cartId, Integer addressId, Integer couponId, Integer grouponRulesId);

    Integer goodscount(String username);
}
