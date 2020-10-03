package com.cskaoyan.bean.GoodsPart;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Product {
    private Integer id;

    private Integer goodsId;

    private String[] specifications;

    private BigDecimal price;

    private Integer number;

    private String url;

    private Date addTime = new Date();

    private Date updateTime = new Date();

    private Boolean deleted = false;


}