package com.cskaoyan.bean.GoodsPart;

import lombok.Data;

import java.util.Date;

@Data
public class Attribute {
    private Integer id;

    private Integer goodsId;

    private String attribute;

    private String value;

    private Date addTime = new Date();

    private Date updateTime = new Date();

    private Boolean deleted = false;

}