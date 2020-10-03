package com.cskaoyan.promoteModule.grouponManage.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class GrouponRules {
    private Integer id;

    private Integer goodsId;

    private String goodsName="默认name";

    private String picUrl;

    private BigDecimal discount;

    private Integer discountMember;

    private Date addTime;

    private Date updateTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date expireTime;

    private Boolean deleted;

}