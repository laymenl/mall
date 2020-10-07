package com.cskaoyan.service.shopService;

import com.cskaoyan.bean.shop.category.Category;
import com.cskaoyan.bean.shop.category.CategoryL1VO;
import com.cskaoyan.bean.shop.category.L1CategoryVO;
import com.cskaoyan.bean.wxvo.GoodsCategoryVO;

import java.util.List;

public interface CategoryService {
    List<CategoryL1VO> list();

    List<L1CategoryVO> listL1();

    Category create(Category category);

    void update(Category category);

    void delete(Category category);

    GoodsCategoryVO wxGoodsCategory(Integer id);
}
