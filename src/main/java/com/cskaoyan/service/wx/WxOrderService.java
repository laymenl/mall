package com.cskaoyan.service.wx;


import com.cskaoyan.bean.OrderPart.OrderGoods;

import com.cskaoyan.bean.wxvo.WxOrderDetailVO;
import com.cskaoyan.bean.wxvo.WxOrderListVO;

public interface WxOrderService {
    public WxOrderListVO list(Integer showType, Integer page, Integer size);
    public WxOrderDetailVO detail(Integer orderId);

    void cancel(Integer orderId);

    void prepay(Integer orderID);

    void refund(Integer orderID);

    void delete(Integer orderID);

    void confirm(Integer orderID);

    OrderGoods goods(Integer orderId, Integer goodsId);

}
