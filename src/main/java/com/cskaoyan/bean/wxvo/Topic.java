package com.cskaoyan.bean.wxvo;

import lombok.Data;

@Data
public class Topic {
    private int id;
    private String title;
    private String subtitle;
    private double price;
    private String readCount;
    private String picUrl;
}
