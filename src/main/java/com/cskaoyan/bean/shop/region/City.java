package com.cskaoyan.bean.shop.region;

import lombok.Data;

import java.util.List;

@Data
public class City {
    List<Area> children;

    private Integer id;

    private String name;

    private Byte type;

    private Integer code;
}
