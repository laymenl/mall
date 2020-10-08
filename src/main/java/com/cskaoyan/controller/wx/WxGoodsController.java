package com.cskaoyan.controller.wx;

import com.cskaoyan.bean.BaseRespVo;
import com.cskaoyan.bean.GoodsPart.Goods;
import com.cskaoyan.bean.wxvo.GoodsCategoryVO;
import com.cskaoyan.bean.wxvo.GoodsCountVO;
import com.cskaoyan.bean.wxvo.GoodsDetailVO;
import com.cskaoyan.bean.wxvo.GoodsListVO;
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

    //categoryId: 1005010
    //page: 1
    //size: 100
    @RequestMapping("list")
    public BaseRespVo list(Integer categoryId, Integer page, Integer size, String sort, String order, String keyword){
        GoodsListVO goodsListVO = goodsService.list(categoryId, page, size, sort, order, keyword);
        return BaseRespVo.ok(goodsListVO);
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
