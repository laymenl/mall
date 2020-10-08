package com.cskaoyan.bean.wxvo;

import com.cskaoyan.bean.shop.order.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderInfoVO {
    String consignee;
    String address;
    Date addTime;
    String orderSn;
    BigDecimal actualPrice;
    String mobile;
    String orderStatusText;
    BigDecimal goodsPrice;
    BigDecimal couponPrice;
    Integer id;
    BigDecimal freightPrice;
    WxOrderListDataHandleOption handleOption;

}
