package com.cskaoyan.bean.wxvo.cart;

import lombok.Data;

import java.util.List;

@Data
public class CartListBean {
    CartTotal cartTotal;
    List cartList;
}
