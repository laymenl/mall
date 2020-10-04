package com.cskaoyan.bean.shop.order;

import lombok.Data;

@Data
public class ShipBO {
    private int orderId;
    private String shipChannel;
    private String shipSn;
}
