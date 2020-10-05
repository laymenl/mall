package com.cskaoyan.service.impl;

import com.cskaoyan.bean.shop.order.Order;
import com.cskaoyan.bean.stat.StatOrder;
import com.cskaoyan.bean.stat.StatOrderExample;
import com.cskaoyan.bean.stat.StatUser;
import com.cskaoyan.bean.stat.StatUserExample;
import com.cskaoyan.bean.stat.VO.OrderData;
import com.cskaoyan.bean.stat.VO.StatVO;
import com.cskaoyan.bean.stat.VO.UserData;
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

//    @Autowired

    @Override
    public StatVO QueryUser() {
        StatUserExample statUserExample = new StatUserExample();
        StatUserExample.Criteria criteria = statUserExample.createCriteria();
        int count = (int) statUserMapper.countByExample(statUserExample);
        StatVO<UserData> userDataStatData = new StatVO<>();
        UserData userData = new UserData();
        userData.setUsers(count);
        List<UserData> userData1 = new ArrayList<>();
        ArrayList<String> strings = new ArrayList<>();
        userData1.add(userData);
        strings.add("day");
        strings.add("users");
        userDataStatData.setColumns(strings);
        userDataStatData.setRows(userData1);
        return userDataStatData;
    }

    @Override
    public StatVO QueryOrder() {

        StatVO<OrderData> orderDataStatData = new StatVO<>();
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
        orderDataStatData.setColumns(strings);
        orderDataStatData.setRows(orderData);
        return orderDataStatData;
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
        StatUserExample statUserExample = new StatUserExample();
        StatUserExample.Criteria criteria = statUserExample.createCriteria();
        int count = (int) statUserMapper.countByExample(statUserExample);
        StatVO<UserData> userDataStatData = new StatVO<>();
        UserData userData = new UserData();
        userData.setUsers(count);
        List<UserData> userData1 = new ArrayList<>();
        ArrayList<String> strings = new ArrayList<>();
        userData1.add(userData);
        strings.add("day");
        strings.add("users");
        userDataStatData.setColumns(strings);
        userDataStatData.setRows(userData1);
        return userDataStatData;
    }

}
