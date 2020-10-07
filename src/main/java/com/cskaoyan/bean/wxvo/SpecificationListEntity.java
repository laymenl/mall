package com.cskaoyan.bean.wxvo;

import com.cskaoyan.bean.GoodsPart.Specification;
import lombok.Data;

import java.util.List;

@Data
public class SpecificationListEntity {

    private List<Specification> valueList;
    private String name;

}