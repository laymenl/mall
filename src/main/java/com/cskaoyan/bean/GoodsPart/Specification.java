package com.cskaoyan.bean.GoodsPart;

import lombok.Data;

import java.util.Date;

@Data
public class Specification {
    private Integer id;

    private Integer goodsId;

    private String specification;

    private String value;

    private String picUrl;

    private Date addTime = new Date();

    private Date updateTime = new Date();

    private Boolean deleted = false;

}