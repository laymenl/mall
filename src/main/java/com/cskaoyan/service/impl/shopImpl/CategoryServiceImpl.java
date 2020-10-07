package com.cskaoyan.service.impl.shopImpl;

import com.cskaoyan.bean.shop.category.Category;
import com.cskaoyan.bean.shop.category.CategoryExample;
import com.cskaoyan.bean.shop.category.CategoryL1VO;
import com.cskaoyan.bean.shop.category.L1CategoryVO;
import com.cskaoyan.bean.wxvo.GoodsCategoryVO;
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

    @Override
    public GoodsCategoryVO wxGoodsCategory(Integer id) {
        Category currentCategory = getCategoryById(id);
        if(currentCategory.getLevel().equals("L1")){
            List<Category>  childCategoryList = getChildCatesById(id);
            currentCategory = childCategoryList.get(0);
        }
        Category parentCategory = getParentCategory(currentCategory);
        List<Category> brotherCategories = getBrotherCategory(currentCategory);
        return new GoodsCategoryVO(currentCategory,brotherCategories,parentCategory);
    }

    private List<Category> getBrotherCategory(Category currentCategory) {
        CategoryExample categoryExample = new CategoryExample();
        categoryExample.createCriteria().andPidEqualTo(currentCategory.getPid())
                .andIdNotEqualTo(currentCategory.getId());
        List<Category> categoryList = categoryMapper4Shop.selectByExample(categoryExample);
        return categoryList;
    }

    private List<Category> getChildCatesById(Integer id) {
        CategoryExample categoryExample = new CategoryExample();
        categoryExample.createCriteria().andPidEqualTo(id);
        List<Category> categories = categoryMapper4Shop.selectByExample(categoryExample);
        return categories;
    }
    /*
    * 通过category的id
    * */
    private Category getCategoryById(Integer id) {
        CategoryExample categoryExample = new CategoryExample();
        categoryExample.createCriteria().andIdEqualTo(id);
        List<Category> categories = categoryMapper4Shop.selectByExample(categoryExample);
        return categories.get(0);
    }

    private Category getParentCategory(Category category){
        Integer pid = category.getPid();
        CategoryExample CategoryExample = new CategoryExample();
        CategoryExample.createCriteria().andIdEqualTo(pid);
        List<Category> parentCategories = categoryMapper4Shop.selectByExample(CategoryExample);
        return parentCategories.get(0);
    }
}
