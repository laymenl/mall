package com.cskaoyan.service.wx;

import com.cskaoyan.bean.wxvo.cart.CartListBean;

public interface WxCartService {
    CartListBean index(String username);
}
