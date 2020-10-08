package com.cskaoyan.bean.wxvo;


import com.cskaoyan.bean.OrderPart.OrderGoods;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WxOrderDetailVO {
    OrderInfoVO orderInfo;
    List<OrderGoods> orderGoods;
}
