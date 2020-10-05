package com.cskaoyan.service.impl;

import com.cskaoyan.bean.GoodsPart.Goods;
import com.cskaoyan.bean.shop.order.Order;
import com.cskaoyan.bean.stat.*;
import com.cskaoyan.bean.stat.VO.GoodsData;
import com.cskaoyan.bean.stat.VO.OrderData;
import com.cskaoyan.bean.stat.VO.StatVO;
import com.cskaoyan.bean.stat.VO.UserData;
import com.cskaoyan.mapper.StatGoodsMapper;
import com.cskaoyan.mapper.StatOrderMapper;
import com.cskaoyan.mapper.StatUserMapper;
import com.cskaoyan.service.StatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatServiceImpl implements StatService {

    @Autowired
    StatUserMapper statUserMapper;

    @Autowired
    StatOrderMapper statOrderMapper;

    @Autowired
    StatGoodsMapper statGoodsMapper;

    @Override
    public StatVO QueryUser() {
        StatUserExample statUserExample = new StatUserExample();
        StatUserExample.Criteria criteria = statUserExample.createCriteria();
        int count = (int) statUserMapper.countByExample(statUserExample);
        StatVO<UserData> userDataStatVO = new StatVO<>();
        UserData userData = new UserData();
        userData.setUsers(count);
        List<UserData> userData1 = new ArrayList<>();
        ArrayList<String> strings = new ArrayList<>();
        userData1.add(userData);
        strings.add("day");
        strings.add("users");
        userDataStatVO.setColumns(strings);
        userDataStatVO.setRows(userData1);
        return userDataStatVO;
    }

    @Override
    public StatVO QueryOrder() {

        StatVO<OrderData> orderDataStatVO = new StatVO<>();
        OrderData orderData1 = new OrderData();
        OrderData orderData2 = new OrderData();
        OrderData orderData3 = new OrderData();
        StatOrderExample statOrderExample = new StatOrderExample();
        StatOrderExample.Criteria criteria = statOrderExample.createCriteria();
        criteria.andAddTimeBetween("2020-04-27 00:00:00","2020-04-28 00:00:00");
        queryOrders(orderData1, statOrderExample, criteria);
        orderData1.setDay("2020-04-27");
        criteria.andAddTimeBetween("2020-09-27 00:00:00","2020-09-28 00:00:00");
        queryOrders(orderData2, statOrderExample, criteria);
        orderData2.setDay("2020-09-27");
        criteria.andAddTimeBetween("2020-10-27 00:00:00","2020-10-28 00:00:00");
        queryOrders(orderData3, statOrderExample, criteria);
        orderData3.setDay("2020-10-27");
        List<OrderData> orderData = new ArrayList<>();
        ArrayList<String> strings = new ArrayList<>();
        orderData.add(orderData1);
        orderData.add(orderData2);
        orderData.add(orderData3);
        strings.add("day");
        strings.add("orders");
        strings.add("customers");
        strings.add("amount");
        strings.add("pcr");
        orderDataStatVO.setColumns(strings);
        orderDataStatVO.setRows(orderData);
        return orderDataStatVO;
    }

    private void queryOrders(OrderData orderData, StatOrderExample statOrderExample, StatOrderExample.Criteria criteria) {
        List<StatOrder> statOrders = statOrderMapper.selectByExample(statOrderExample);
        Double amount = 0.0;
        Integer orders = 0;
        for (StatOrder statOrder : statOrders) {
            amount += statOrder.getOrderPrice().doubleValue();
            orders ++;
        }
        long customers = statOrderMapper.countDistinctId(statOrderExample);
        Double pcr = amount/customers;
        orderData.setAmount(amount);
        orderData.setCustomers((int) customers);
        orderData.setPcr(pcr);
        orderData.setOrders(orders);
        criteria.getAllCriteria().clear();
    }

    @Override
    public StatVO QueryGoods() {
        StatVO<GoodsData> goodsDataStatVO = new StatVO<>();
        GoodsData goodsData1 = new GoodsData();
        GoodsData goodsData2 = new GoodsData();
        GoodsData goodsData3 = new GoodsData();
        GoodsData goodsData4 = new GoodsData();
        StatGoodsExample statGoodsExample = new StatGoodsExample();
        StatGoodsExample.Criteria criteria = statGoodsExample.createCriteria();
        criteria.andAddTimeBetween("2020-04-27 00:00:00","2020-04-28 00:00:00");
        queryGoods(goodsData1, statGoodsExample, criteria);
        goodsData1.setDay("2020-04-27");
        criteria.andAddTimeBetween("2020-10-01 00:00:00","2020-10-02 00:00:00");
        queryGoods(goodsData2, statGoodsExample, criteria);
        goodsData2.setDay("2020-10-01");
        criteria.andAddTimeBetween("2020-10-02 00:00:00","2020-10-03 00:00:00");
        queryGoods(goodsData3, statGoodsExample, criteria);
        goodsData3.setDay("2020-10-02");
        criteria.andAddTimeBetween("2020-10-05 00:00:00","2020-10-06 00:00:00");
        queryGoods(goodsData4, statGoodsExample, criteria);
        goodsData4.setDay("2020-10-05");
        List<GoodsData> goodsData = new ArrayList<>();
        ArrayList<String> strings = new ArrayList<>();
        goodsData.add(goodsData1);
        goodsData.add(goodsData2);
        goodsData.add(goodsData3);
        goodsData.add(goodsData4);
        strings.add("day");
        strings.add("orders");
        strings.add("products");
        strings.add("amount");
        goodsDataStatVO.setColumns(strings);
        goodsDataStatVO.setRows(goodsData);
        return goodsDataStatVO;
    }

    private void queryGoods(GoodsData goodsData, StatGoodsExample statGoodsExample, StatGoodsExample.Criteria criteria) {
        List<StatGoods> statGoods = statGoodsMapper.selectByExample(statGoodsExample);
        Double amount = 0.0;
        Integer orders = 0;
        for (StatGoods statGood : statGoods) {
            amount += statGood.getPrice().doubleValue();
            orders ++;
        }
        long products = statGoodsMapper.countDistinctProducts(statGoodsExample);
        goodsData.setAmount(amount);
        goodsData.setProducts((int) products);
        goodsData.setOrders(orders);
        criteria.getAllCriteria().clear();
    }

}
