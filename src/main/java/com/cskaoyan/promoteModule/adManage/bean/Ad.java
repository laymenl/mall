package com.cskaoyan.promoteModule.adManage.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ad {
    private Integer id;

    private String name;

    private String link;

    private String url;

    private Byte position;

    private String content;

    private Date startTime;

    private Date endTime;

    private Boolean enabled;

    private Date addTime;

    private Date updateTime;

    private Boolean deleted;

}