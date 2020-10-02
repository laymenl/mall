package com.cskaoyan.service.impl;

import com.cskaoyan.bean.BaseRespVo;
import com.cskaoyan.bean.GoodsPart.*;
import com.cskaoyan.bean.GoodsPart.VO.BrandVO;
import com.cskaoyan.bean.GoodsPart.VO.CatAndBrandVO;
import com.cskaoyan.bean.GoodsPart.VO.CategoryVO;
import com.cskaoyan.bean.ListBean;
import com.cskaoyan.mapper.BrandMapper;
import com.cskaoyan.mapper.CategoryMapper;
import com.cskaoyan.mapper.GoodsMapper;
import com.cskaoyan.service.GoodsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    CategoryMapper categoryMapper;

    @Autowired
    BrandMapper brandMapper;

    @Override
    public ListBean queryGoodsListBean(Integer page, Integer limit, String sort, String order) {
        PageHelper.startPage(page, limit);
        GoodsExample goodsExample = new GoodsExample();
        goodsExample.setOrderByClause(sort + " " + order);
        List<Goods> goods = goodsMapper.selectByExample(goodsExample);
        PageInfo pageInfo = new PageInfo(goods);
        long total = pageInfo.getTotal();
        ListBean listBean = new ListBean(goods, total);
        return listBean;
    }

    @Override
    public CatAndBrandVO catAndBrand() {
        List<CategoryVO> categoryList = categoryMapper.getAllCategoryVO();
        List<BrandVO> brandList = brandMapper.getAllBrandVO();
        CatAndBrandVO catAndBrandVO = new CatAndBrandVO(categoryList, brandList);
        return catAndBrandVO;
    }
}
