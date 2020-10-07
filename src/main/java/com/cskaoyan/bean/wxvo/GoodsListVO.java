package com.cskaoyan.bean.wxvo;

import com.cskaoyan.bean.GoodsPart.Goods;
import com.cskaoyan.bean.shop.category.Category;
import lombok.Data;

import java.util.List;

@Data
public class GoodsListVO {

    private List<Goods> goodsList;

    private int count;

    private List<Category> filterCategoryList;

}
