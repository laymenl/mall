package com.cskaoyan.controller.wx;

import com.cskaoyan.bean.BaseRespVo;
import com.cskaoyan.bean.GoodsPart.Goods;
import com.cskaoyan.bean.wxvo.GoodsCategoryVO;
import com.cskaoyan.bean.wxvo.GoodsCountVO;
import com.cskaoyan.bean.wxvo.GoodsDetailVO;
import com.cskaoyan.service.GoodsService;
import com.cskaoyan.service.shopService.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/wx/goods")
public class WxGoodsController {

    @Autowired
    GoodsService goodsService;

    @Autowired
    CategoryService categoryService;

    @RequestMapping("count")
    public BaseRespVo count(){
        int total = goodsService.countTotal();
        return BaseRespVo.ok(new GoodsCountVO(total));
    }

    @RequestMapping("category")
    public BaseRespVo category(Integer id){
        GoodsCategoryVO categoryVO = categoryService.wxGoodsCategory(id);
        return BaseRespVo.ok(categoryVO);
    }

    @RequestMapping("detail")
    public BaseRespVo detail(int id){
        GoodsDetailVO goodsDetailVO = goodsService.wxDetail(id);
        return BaseRespVo.ok(goodsDetailVO);
    }

    @RequestMapping("related")
    public BaseRespVo  related(Integer id){
        List<Goods> goodsList = goodsService.related(id);
        return BaseRespVo.ok(goodsList);
    }



}
