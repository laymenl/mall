package com.cskaoyan.mapper;

import com.cskaoyan.bean.GoodsPart.VO.CategoryVO;

import java.util.List;

public interface CategoryMapper {

    List<CategoryVO> getAllUnDeletedCategoryVO();


    Integer getPidById(Integer id);
}
