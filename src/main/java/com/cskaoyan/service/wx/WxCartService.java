package com.cskaoyan.service.wx;

import com.cskaoyan.bean.wxvo.cart.Cart;
import com.cskaoyan.bean.wxvo.cart.CartBO;
import com.cskaoyan.bean.wxvo.cart.CartListBean;

public interface WxCartService {
    CartListBean index(String username);

    void update(Cart cart);

    CartListBean checked(CartBO cartBO, String username);

    CartListBean delete(CartBO cartBO, String username);
}
