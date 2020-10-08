package com.cskaoyan.service.impl;

import com.cskaoyan.bean.GoodsPart.*;
import com.cskaoyan.bean.GoodsPart.VO.GoodsVO;
import com.cskaoyan.bean.GoodsPart.VO.BrandVO;
import com.cskaoyan.bean.GoodsPart.VO.CatAndBrandVO;
import com.cskaoyan.bean.GoodsPart.VO.CategoryVO;
import com.cskaoyan.bean.ListBean;
import com.cskaoyan.bean.User;
import com.cskaoyan.bean.UserExample;
import com.cskaoyan.bean.collect.UserCollectExample;
import com.cskaoyan.bean.history.UserSearchHistory;
import com.cskaoyan.bean.shop.brand.Brand;
import com.cskaoyan.bean.shop.brand.BrandExample;
import com.cskaoyan.bean.shop.category.Category;
import com.cskaoyan.bean.shop.category.CategoryExample;
import com.cskaoyan.bean.shop.issue.Issue;
import com.cskaoyan.bean.shop.issue.IssueExample;
import com.cskaoyan.bean.shop.keyword.Keyword;
import com.cskaoyan.bean.wxvo.*;
import com.cskaoyan.mapper.*;
import com.cskaoyan.mapper.shopMapper.BrandMapper4Shop;
import com.cskaoyan.mapper.shopMapper.CategoryMapper4Shop;
import com.cskaoyan.mapper.shopMapper.IssueMapper4Shop;
import com.cskaoyan.promoteModule.grouponManage.bean.listRecord.Groupon;
import com.cskaoyan.mapper.shopMapper.KeywordMapper4Shop;
import com.cskaoyan.service.GoodsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

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
    UserMapper userMapper;

    @Autowired
    CategoryMapper categoryMapper;

    @Autowired
    BrandMapper brandMapper;

    @Autowired
    BrandMapper4Shop brandMapper4Shop;

    @Autowired
    IssueMapper4Shop issueMapper;

    @Autowired
    UserCollectMapper collectMapper;

    @Autowired
    CategoryMapper4Shop categoryMapper4Shop;

    @Autowired
    UserSearchHistoryMapper searchHistoryMapper;

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

    @Override
    public int countTotal() {
        GoodsExample goodsExample = new GoodsExample();
        goodsExample.createCriteria().andDeletedEqualTo(false);
        int count = (int) goodsMapper.countByExample(goodsExample);
        return count;
    }

    @Override
    public List<Goods> related(Integer id) {
        GoodsExample goodsExample = new GoodsExample();
        goodsExample.createCriteria().andIdEqualTo(id);
        List<Goods> goodsList = goodsMapper.selectByExample(goodsExample);
        Goods goods = goodsList.get(0);
        GoodsExample relatedGoodsExample = new GoodsExample();
        relatedGoodsExample.createCriteria().andCategoryIdEqualTo(goods.getCategoryId());
        List<Goods> relatedGoodsList = goodsMapper.selectByExample(goodsExample);
        return relatedGoodsList;
    }

    @Override
    public GoodsDetailVO wxDetail(int id) {
        SpecificationExample specificationExample = new SpecificationExample();
        specificationExample.createCriteria().andGoodsIdEqualTo(id);
        List<Specification> specifications = specificationMapper.selectByExample(specificationExample);
        HashSet<String> set = new HashSet<>();
        for (Specification specification : specifications) {
            set.add(specification.getSpecification());
        }
        List<SpecificationListEntity> specificationListEntities = new ArrayList<SpecificationListEntity>();
        for (String s : set) {
            SpecificationListEntity specificationListEntity = new SpecificationListEntity();
            specificationListEntity.setName(s);
            SpecificationExample specificationExample1 = new SpecificationExample();
            specificationExample1.createCriteria().andGoodsIdEqualTo(id).andSpecificationEqualTo(s);
            List<Specification> specifications1 = specificationMapper.selectByExample(specificationExample);
            specificationListEntity.setValueList(specifications1);
            specificationListEntities.add(specificationListEntity);
        }
        List<Issue> issues = issueMapper.selectByExample(new IssueExample());
        UserCollectExample collectExample = new UserCollectExample();
        collectExample.createCriteria().andValueIdEqualTo(id);
        int userHasCollect = (int) collectMapper.countByExample(collectExample);
        CommentEntity commentEntity = new CommentEntity();
        List<CommentInfo> commentList = goodsMapper.commentVOSelect(id);
        commentEntity.setData(commentList);
        commentEntity.setCount(commentList.size());
        AttributeExample attributeExample = new AttributeExample();
        attributeExample.createCriteria().andGoodsIdEqualTo(id);
        List<Attribute> attributes = attributeMapper.selectByExample(attributeExample);
        GoodsExample goodsExample = new GoodsExample();
        goodsExample.createCriteria().andIdEqualTo(id);
        List<Goods> goodsList = goodsMapper.selectByExample(goodsExample);
        Goods info = goodsList.get(0);
        BrandExample brandExample = new BrandExample();
        brandExample.createCriteria().andIdEqualTo(info.getBrandId());
        List<Brand> brands = brandMapper4Shop.selectByExample(brandExample);
        Brand brand = brands.size() > 0 ? brands.get(0) : null;
        ProductExample productExample = new ProductExample();
        productExample.createCriteria().andGoodsIdEqualTo(id);
        List<Product> products = productMapper.selectByExample(productExample);
        GoodsDetailVO goodsDetailVO = new GoodsDetailVO(specificationListEntities, new ArrayList<>(), issues, userHasCollect,
                commentEntity, attributes, brand, products, info);

        return goodsDetailVO;
    }

    @Override
    public GoodsListVO list(Integer categoryId, Integer page, Integer size, String sort, String order, String keyword) {
        GoodsListVO goodsListVO = new GoodsListVO();
        GoodsExample goodsExample = new GoodsExample();
        if(order != null && sort != null){
            goodsExample.setOrderByClause(sort + " " + order);
        }
//        goodsExample.createCriteria().andCategoryIdEqualTo(categoryId).andDeletedEqualTo(false);
        GoodsExample.Criteria criteria = goodsExample.createCriteria();
        criteria.andDeletedEqualTo(false);
        if(categoryId != 0 && categoryId != null){
            criteria.andCategoryIdEqualTo(categoryId);
        }
        if(keyword != null){
            criteria.andNameLike("%" + keyword + "%");
            UserSearchHistory userSearchHistory = new UserSearchHistory();
            userSearchHistory.setKeyword(keyword);
            Subject subject = SecurityUtils.getSubject();
            Integer userId = null;
            if(subject.isAuthenticated()){
                String username = (String) subject.getPrincipals().getPrimaryPrincipal();
                UserExample userExample = new UserExample();
                userExample.createCriteria().andUsernameEqualTo(username);
                List<User> users = userMapper.selectByExample(userExample);
                userId = users.size() > 0 ? users.get(0).getId() : null;
                userSearchHistory.setUserId(userId);
                searchHistoryMapper.insert(userSearchHistory);
            }
        }
        PageHelper.startPage(page, size);
        List<Goods> goodsList = goodsMapper.selectByExample(goodsExample);
        CategoryExample categoryExample = new CategoryExample();
        categoryExample.createCriteria().andDeletedEqualTo(false).andLevelEqualTo("L2");
        List<Category> categoryList = categoryMapper4Shop.selectByExample(categoryExample);
        goodsListVO.setGoodsList(goodsList);
        goodsListVO.setCount(goodsList.size());
        goodsListVO.setFilterCategoryList(categoryList);
        return goodsListVO;
    }

}
