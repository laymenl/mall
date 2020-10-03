package com.cskaoyan.controller;

import com.cskaoyan.bean.GoodsPart.Attribute;
import com.cskaoyan.bean.GoodsPart.BO.GoodsCreateBO;
import com.cskaoyan.bean.BaseRespVo;
import com.cskaoyan.bean.GoodsPart.Goods;
import com.cskaoyan.bean.GoodsPart.Product;
import com.cskaoyan.bean.GoodsPart.Specification;
import com.cskaoyan.bean.GoodsPart.VO.CatAndBrandVO;
import com.cskaoyan.bean.ListBean;
import com.cskaoyan.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("admin/goods")
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    @RequestMapping("list")
    public BaseRespVo list(Integer page, Integer limit, String sort, String order){
        ListBean listBean = goodsService.queryGoodsListBean(page, limit, sort, order);
        return BaseRespVo.ok(listBean);
    }

    @RequestMapping("catAndBrand")
    public BaseRespVo catAndBrand(){
        CatAndBrandVO catAndBrandVO = goodsService.catAndBrand();
        return BaseRespVo.ok(catAndBrandVO);
    }

    @RequestMapping("create")
    public BaseRespVo create(@RequestBody GoodsCreateBO goodsCreateBO){
        System.out.println(goodsCreateBO);
        Goods goods = goodsCreateBO.getGoods();
        List<Specification> specifications = goodsCreateBO.getSpecifications();
        List<Product> products = goodsCreateBO.getProducts();
        List<Attribute> attributes = goodsCreateBO.getAttributes();
        try{
            int code = goodsService.create(goods, specifications, products, attributes);
        }catch (Exception exception){
            return BaseRespVo.fail("插入错误");
        }
        return BaseRespVo.ok();
    }

}
