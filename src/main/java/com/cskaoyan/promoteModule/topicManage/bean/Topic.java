package com.cskaoyan.promoteModule.topicManage.bean;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Topic {
    private Integer id;

    private String title="''";

    private String subtitle="''";

    private BigDecimal price;

    private String readCount="1k";

    private String picUrl="";

    private Integer sortOrder=100;

    private String[] goods;

    private Date addTime;

    private Date updateTime;

    private Boolean deleted;

    private String content;

}