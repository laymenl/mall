package com.cskaoyan.service.impl;

import com.cskaoyan.bean.GoodsPart.Goods;
import com.cskaoyan.bean.GoodsPart.GoodsExample;
import com.cskaoyan.bean.ListBean;
import com.cskaoyan.mapper.GoodsMapper;
import com.cskaoyan.service.GoodsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public ListBean queryGoodsListBean(Integer page, Integer limit, String sort, String order) {
        PageHelper.startPage(page, limit);
        GoodsExample goodsExample = new GoodsExample();
        goodsExample.setOrderByClause(sort + " " + order);
        List<Goods> goods = goodsMapper.selectByExample(goodsExample);
        PageInfo pageInfo = new PageInfo(goods);
        long total = pageInfo.getTotal();
        ListBean listBean = new ListBean(goods, total);
        return listBean;
    }
}
