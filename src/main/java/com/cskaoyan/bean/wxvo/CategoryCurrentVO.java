package com.cskaoyan.bean.wxvo;

import com.cskaoyan.bean.shop.category.Category;
import lombok.Data;

import java.util.List;

@Data
public class CategoryCurrentVO {
    private Category currentCategory;
    private List<Category> currentSubCategory;
}
