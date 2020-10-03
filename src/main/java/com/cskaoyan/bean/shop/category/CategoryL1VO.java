package com.cskaoyan.bean.shop.category;

import lombok.Data;

import java.util.List;
@Data
public class CategoryL1VO {
    private int id;
    private String name;
    private String keywords;
    private String desc;
    private String iconUrl;
    private String picUrl;
    private String level;
    private List<CategoryL2VO> children;
}
