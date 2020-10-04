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

import java.util.Date;
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
    public ListBean queryGoodsListBean(Integer page, Integer limit, String sort, String order, String goodsSn, String name) {
        PageHelper.startPage(page, limit);
        GoodsExample goodsExample = new GoodsExample();
        goodsExample.setOrderByClause(sort + " " + order);
        GoodsExample.Criteria criteria = goodsExample.createCriteria();
        if(goodsSn != null && !goodsSn.isEmpty()){
            criteria.andGoodsSnEqualTo(goodsSn);
        }
        if(name != null && !name.isEmpty()){
            criteria.andNameEqualTo(name);
        }
        criteria.andDeletedEqualTo(false);
        List<Goods> goods = goodsMapper.selectByExample(goodsExample);
        PageInfo pageInfo = new PageInfo(goods);
        long total = pageInfo.getTotal();
        ListBean listBean = new ListBean(goods, total);
        return listBean;
    }

    @Override
    public CatAndBrandVO catAndBrand() {
        List<CategoryVO> categoryList = categoryMapper.getAllUnDeletedCategoryVO();
        List<BrandVO> brandList = brandMapper.getAllUnDeletedBrandVO();
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
        ProductExample productExample = new ProductExample();
        AttributeExample attributeExample = new AttributeExample();
        if(goodsId != null){
            //查询的是deleted=false
            specificationExample.createCriteria().andGoodsIdEqualTo(goodsId).andDeletedEqualTo(false);
            productExample.createCriteria().andGoodsIdEqualTo(goodsId).andDeletedEqualTo(false);
            attributeExample.createCriteria().andGoodsIdEqualTo(goodsId).andDeletedEqualTo(false);
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
    @Transactional
    public void update(Goods goods, List<Specification> specifications, List<Product> products, List<Attribute> attributes) throws RuntimeException{
        try{
            GoodsExample goodsExample = new GoodsExample();
            goodsExample.createCriteria().andIdEqualTo(goods.getId());
            goods.setUpdateTime(new Date());
            goodsMapper.updateByExample(goods, goodsExample);
            //先根据goodsId把所有deleted设置为true，并更新update_time
            specificationMapper.setDeletedTrueByGoodsId(goods.getId(), new Date());
            for (Specification specification : specifications) {
                //插入新增
                if(specification.getId() == null){
                    specification.setGoodsId(goods.getId());
                    specificationMapper.insert(specification);
                }
                //update已有
                else {
                    SpecificationExample specificationExample = new SpecificationExample();
                    specificationExample.createCriteria().andIdEqualTo(specification.getId());
                    specificationMapper.updateByExample(specification, specificationExample);
                }
            }
            //先根据goodsId把所有deleted设置为true，并更新update_time
            attributeMapper.setDeletedTrueByGoodsId(goods.getId(), new Date());
            for (Attribute attribute : attributes) {
                if(attribute.getId() == null){
                    attribute.setGoodsId(goods.getId());
                    attributeMapper.insert(attribute);
                }
                else {
                    AttributeExample attributeExample = new AttributeExample();
                    attributeExample.createCriteria().andIdEqualTo(attribute.getId());
                    attributeMapper.updateByExample(attribute, attributeExample);
                }
            }
            for (Product product : products) {
                ProductExample productExample = new ProductExample();
                productExample.createCriteria().andIdEqualTo(product.getId());
                product.setUpdateTime(new Date());
                productMapper.updateByExample(product, productExample);
            }
        }catch (Exception exception){
            exception.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        goodsMapper.setDeletedTrue(id);
    }

}
