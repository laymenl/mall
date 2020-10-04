package com.cskaoyan.mapper;

import com.cskaoyan.bean.GoodsPart.VO.BrandVO;

import java.util.List;

public interface BrandMapper {
    List<BrandVO> getAllUnDeletedBrandVO();
}
