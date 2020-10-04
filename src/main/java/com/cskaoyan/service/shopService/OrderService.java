package com.cskaoyan.service.shopService;

import com.cskaoyan.bean.ListBean;
import com.cskaoyan.bean.shop.order.OrderListBean;
import com.cskaoyan.bean.shop.order.RefundBO;
import com.cskaoyan.bean.shop.order.ShipBO;

public interface OrderService {
    ListBean list(Short[] orderStatusArray, Integer userId, String orderSn, Integer page, Integer limit, String sort, String order);

    OrderListBean detail(Integer id);

    void ship(ShipBO shipBO);

    void refund(RefundBO refundBO);
}
