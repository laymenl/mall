package com.cskaoyan.service.wx;

import com.cskaoyan.bean.shop.category.Category;
import com.cskaoyan.bean.wxvo.CatalogVO;
import com.cskaoyan.bean.wxvo.CategoryCurrentVO;
import com.cskaoyan.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public CatalogVO index() {
        Category currentCategory = categoryMapper.SelectCurrentCategory();
        List<Category> categoryList = categoryMapper.SelectCategoryList();
        List<Category> currentSubCategory = categoryMapper.SelectCurrentSubCategory();
        CatalogVO catalogVO = new CatalogVO();
        catalogVO.setCurrentCategory(currentCategory);
        catalogVO.setCategoryList(categoryList);
        catalogVO.setCurrentSubCategory(currentSubCategory);
        return catalogVO;
    }

    @Override
    public CategoryCurrentVO current(Integer id) {
        Category currentCategory = categoryMapper.SelectCurrentCategoryById(id);
        List<Category> currentSubCategory = categoryMapper.SelectCurrentSubCategoryById(id);
        CategoryCurrentVO categoryCurrentVO = new CategoryCurrentVO();
        categoryCurrentVO.setCurrentCategory(currentCategory);
        categoryCurrentVO.setCurrentSubCategory(currentSubCategory);
        return categoryCurrentVO;
    }
}
