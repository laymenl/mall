package com.cskaoyan.service.wx;

<<<<<<< HEAD
=======
import com.cskaoyan.bean.OrderPart.OrderGoods;
>>>>>>> 1109be14e2f4f112ea4ce734cadacdfd8abca678
import com.cskaoyan.bean.wxvo.WxOrderDetailVO;
import com.cskaoyan.bean.wxvo.WxOrderListVO;

public interface WxOrderService {
    public WxOrderListVO list(Integer showType, Integer page, Integer size);
    public WxOrderDetailVO detail(Integer orderId);

    void cancel(Integer orderId);
<<<<<<< HEAD
=======
    void prepay(Integer orderID);

    void refund(Integer orderID);

    void delete(Integer orderID);

    void confirm(Integer orderID);

    OrderGoods goods(Integer orderId, Integer goodsId);
>>>>>>> 1109be14e2f4f112ea4ce734cadacdfd8abca678
}
