package com.cskaoyan.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Storage {
    private Integer id;

    private String key;

    private String name;

    private String type;

    private Integer size;

    private String url;

    private Date addTime;

    private Date updateTime;

    private Boolean deleted;

}