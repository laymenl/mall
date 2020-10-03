package com.cskaoyan.bean.shop.brand;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class BrandVO {
    private int id;
    private String name;
    private String desc;
    private String picUrl;
    private BigDecimal floorPrice;
    private Date addTime;
    private Date updateTime;
}
