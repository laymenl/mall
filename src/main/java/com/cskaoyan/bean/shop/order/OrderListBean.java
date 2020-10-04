package com.cskaoyan.bean.shop.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderListBean {
    Order order;
    List orderGoods;
    User user;
}
