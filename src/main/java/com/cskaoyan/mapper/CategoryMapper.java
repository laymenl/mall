package com.cskaoyan.mapper;

import com.cskaoyan.bean.GoodsPart.VO.CategoryVO;
import com.cskaoyan.bean.shop.category.Category;

import java.util.List;

public interface CategoryMapper {

    List<CategoryVO> getAllUnDeletedCategoryVO();


    Integer getPidById(Integer id);


    Category selectByPrimaryKey(Integer categoryId);
}
