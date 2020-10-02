package com.cskaoyan.bean.GoodsPart.VO;

import lombok.Data;

@Data
public class CategoryVO {
    Integer value;
    String label;
    CategoryVO[] children;
}
