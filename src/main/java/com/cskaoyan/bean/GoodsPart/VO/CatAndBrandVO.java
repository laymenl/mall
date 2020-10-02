package com.cskaoyan.bean.GoodsPart.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CatAndBrandVO {
    private List<CategoryVO> categoryList;
    private List<BrandVO> brandList;
}
