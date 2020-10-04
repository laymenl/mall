package com.cskaoyan.bean.shop.order;

import lombok.Data;

@Data
public class RefundBO {
    Integer orderId;
    Integer refundMoney;
}
