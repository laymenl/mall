package com.cskaoyan.controller.shopController;

import com.cskaoyan.bean.BaseRespVo;
import com.cskaoyan.bean.shop.category.Category;
import com.cskaoyan.bean.shop.category.CategoryL1VO;
import com.cskaoyan.bean.shop.category.L1CategoryVO;
import com.cskaoyan.service.shopService.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("admin/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @RequestMapping("list")
    public BaseRespVo list(){
        List<CategoryL1VO> categoryList = categoryService.list();
        return BaseRespVo.ok(categoryList);
    }
    @RequestMapping("l1")
    public BaseRespVo listL1(){
        List<L1CategoryVO> categoryList = categoryService.listL1();
        return BaseRespVo.ok(categoryList);
    }
    @RequestMapping(value = "create",method = RequestMethod.POST)
    public BaseRespVo create(@RequestBody Category category){
        Category data = categoryService.create(category);
        return BaseRespVo.ok(data);
    }
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public BaseRespVo update(@RequestBody Category category){
        categoryService.update(category);
        return BaseRespVo.ok();
    }
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public BaseRespVo delete(@RequestBody Category category){
        categoryService.delete(category);
        return BaseRespVo.ok();
    }
}
