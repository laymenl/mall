package com.cskaoyan.service.impl;

import com.cskaoyan.bean.DashBoardVO;
import com.cskaoyan.bean.GoodsPart.GoodsExample;
import com.cskaoyan.bean.GoodsPart.ProductExample;
import com.cskaoyan.bean.UserExample;
import com.cskaoyan.bean.shop.order.OrderExample;
import com.cskaoyan.mapper.GoodsMapper;
import com.cskaoyan.mapper.ProductMapper;
import com.cskaoyan.mapper.UserMapper;
import com.cskaoyan.mapper.shopMapper.OrderMapper4Shop;
import com.cskaoyan.service.DashBoradService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashBoardServiceImpl implements DashBoradService {

    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    ProductMapper productMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    OrderMapper4Shop orderMapper;


    @Override
    public DashBoardVO dashBoard() {
        GoodsExample goodsExample = new GoodsExample();
        ProductExample productExample = new ProductExample();
        UserExample userExample = new UserExample();
        OrderExample orderExample = new OrderExample();
        goodsExample.createCriteria().andDeletedEqualTo(false);
        productExample.createCriteria().andDeletedEqualTo(false);
        userExample.createCriteria().andDeletedEqualTo(false);
        orderExample.createCriteria().andDeletedEqualTo(false);
        int goodsTotal = (int) goodsMapper.countByExample(goodsExample);
        int productTotal = (int) productMapper.countByExample(productExample);
        int userTotal = (int) userMapper.countByExample(userExample);
        int orderTotal = (int) orderMapper.countByExample(orderExample);
        DashBoardVO dashBoardVO = new DashBoardVO(goodsTotal, userTotal, productTotal, orderTotal);
        return dashBoardVO;
    }
}
