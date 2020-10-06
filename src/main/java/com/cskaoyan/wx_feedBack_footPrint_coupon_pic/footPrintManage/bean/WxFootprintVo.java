package com.cskaoyan.wx_feedBack_footPrint_coupon_pic.footPrintManage.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WxFootprintVo {
    private String brief;
    private String picUrl;
    private Date addTime;
    private Integer goodsId;
    private String name;
    private Integer id;
    private BigDecimal retailPrice;

}
