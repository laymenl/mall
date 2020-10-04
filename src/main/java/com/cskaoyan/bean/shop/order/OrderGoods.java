package com.cskaoyan.bean.shop.order;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
@Data
public class OrderGoods {
    private Integer id;

    private Integer orderId;

    private Integer goodsId;

    private String goodsName;

    private String goodsSn;

    private Integer productId;

    private Short number;

    private BigDecimal price;

    private String[] specifications;

    private String picUrl;

    private Integer comment;

    private Date addTime;

    private Date updateTime;

    private Boolean deleted;

}