package com.cskaoyan.service.impl.shopImpl;

import com.cskaoyan.bean.shop.category.Category;
import com.cskaoyan.bean.shop.category.CategoryExample;
import com.cskaoyan.bean.shop.category.CategoryL1VO;
import com.cskaoyan.bean.shop.category.L1CategoryVO;
import com.cskaoyan.mapper.shopMapper.CategoryMapper4Shop;
import com.cskaoyan.service.shopService.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper4Shop categoryMapper4Shop;


    @Override
    public List<CategoryL1VO> list() {
        List<CategoryL1VO> list = categoryMapper4Shop.getList();
        return list;
    }

    @Override
    public List<L1CategoryVO> listL1() {
        List<L1CategoryVO> list = categoryMapper4Shop.getListL1();
        return list;
    }

    @Override
    @Transactional
    public Category create(Category category) {
        category.setAddTime(new Date());
        category.setUpdateTime(new Date());
        categoryMapper4Shop.insertSelective(category);
        int i = categoryMapper4Shop.selectLastId();
        Category data = categoryMapper4Shop.selectByPrimaryKey(i);
        return data;
    }

    @Override
    @Transactional
    public void update(Category category) {
        CategoryExample categoryExample = new CategoryExample();
        //
        categoryExample.createCriteria().andIdEqualTo(category.getId());
        category.setUpdateTime(new Date());
        //                                           修改记录  指定数据里的数据
        categoryMapper4Shop.updateByExampleSelective(category,categoryExample);
    }

    @Override
    @Transactional
    public void delete(Category category) {
        CategoryExample categoryExample = new CategoryExample();
        categoryExample.createCriteria().andIdEqualTo(category.getId());
        categoryMapper4Shop.deleteByExample(categoryExample);
    }
}
