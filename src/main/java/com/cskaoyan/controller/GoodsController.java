package com.cskaoyan.controller;

import com.cskaoyan.bean.GoodsPart.BO.GoodsCreateBO;
import com.cskaoyan.bean.BaseRespVo;
import com.cskaoyan.bean.GoodsPart.VO.CatAndBrandVO;
import com.cskaoyan.bean.ListBean;
import com.cskaoyan.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        //TODO 插入数据库
        return BaseRespVo.ok();
    }

}
