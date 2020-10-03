package com.cskaoyan.controller;

import com.cskaoyan.bean.GoodsPart.Attribute;
import com.cskaoyan.bean.GoodsPart.VO.GoodsVO;
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
    public BaseRespVo create(@RequestBody GoodsVO goodsCreateBO){
        System.out.println(goodsCreateBO);
        Goods goods = goodsCreateBO.getGoods();
        List<Specification> specifications = goodsCreateBO.getSpecifications();
        List<Product> products = goodsCreateBO.getProducts();
        List<Attribute> attributes = goodsCreateBO.getAttributes();
        try{
            goodsService.create(goods, specifications, products, attributes);
        }catch (Exception exception){
            return BaseRespVo.fail("插入错误");
        }
        return BaseRespVo.ok();
    }

    @RequestMapping("detail")
    public BaseRespVo detail(Integer id){
        GoodsVO goodsDeatiVo = goodsService.detail(id);
        return BaseRespVo.ok(goodsDeatiVo);
    }

    @RequestMapping("update")
    public BaseRespVo update(@RequestBody GoodsVO goodsVO){
        Goods goods = goodsVO.getGoods();
        List<Attribute> attributes = goodsVO.getAttributes();
        List<Product> products = goodsVO.getProducts();
        List<Specification> specifications = goodsVO.getSpecifications();
        try{
            goodsService.update(goods, specifications, products, attributes);
        }catch (Exception exception){
            return BaseRespVo.fail("更新错误");
        }
        return BaseRespVo.ok();
    }


}
