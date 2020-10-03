package com.cskaoyan.service.impl;

import com.cskaoyan.bean.GoodsPart.*;
import com.cskaoyan.bean.GoodsPart.VO.GoodsVO;
import com.cskaoyan.bean.GoodsPart.VO.BrandVO;
import com.cskaoyan.bean.GoodsPart.VO.CatAndBrandVO;
import com.cskaoyan.bean.GoodsPart.VO.CategoryVO;
import com.cskaoyan.bean.ListBean;
import com.cskaoyan.mapper.*;
import com.cskaoyan.service.GoodsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    SpecificationMapper specificationMapper;

    @Autowired
    ProductMapper productMapper;

    @Autowired
    AttributeMapper attributeMapper;

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

    @Transactional
    @Override
    public void create(Goods goods, List<Specification> specifications, List<Product> products, List<Attribute> attributes) throws RuntimeException{
        try{
            int insertGoods = goodsMapper.insert(goods);
            int insertSpecifications = specificationMapper.insertSpecifications(specifications, goods.getId());
            int insertProducts = productMapper.insertProducts(products, goods.getId());
            int insertAttributes = attributeMapper.insertAttributes(attributes, goods.getId());
        }catch (Exception exception){
            exception.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public GoodsVO detail(Integer goodsId) {
        Goods goods = goodsMapper.selectByPrimaryKey(goodsId);
        SpecificationExample specificationExample = new SpecificationExample();
        SpecificationExample.Criteria specificationExampleCriteria = specificationExample.createCriteria();
        ProductExample productExample = new ProductExample();
        ProductExample.Criteria productExampleCriteria = productExample.createCriteria();
        AttributeExample attributeExample = new AttributeExample();
        AttributeExample.Criteria attributeExampleCriteria = attributeExample.createCriteria();
        if(goodsId != null){
            specificationExampleCriteria.andGoodsIdEqualTo(goodsId);
            productExampleCriteria.andGoodsIdEqualTo(goodsId);
            attributeExampleCriteria.andGoodsIdEqualTo(goodsId);
        }
        List<Specification> specifications = specificationMapper.selectByExample(specificationExample);
        List<Product> products = productMapper.selectByExample(productExample);
        List<Attribute> attributes = attributeMapper.selectByExample(attributeExample);
        Integer pid = categoryMapper.getPidById(goods.getCategoryId());
        Integer[] categoryIds = {pid, goods.getCategoryId()};
        GoodsVO goodsVO = new GoodsVO(goods, products, specifications, attributes, categoryIds);
        return goodsVO;
    }

    @Override
    public void update(Goods goods, List<Specification> specifications, List<Product> products, List<Attribute> attributes) {
//        goodsMapper.deleteByExample();
    }
}
