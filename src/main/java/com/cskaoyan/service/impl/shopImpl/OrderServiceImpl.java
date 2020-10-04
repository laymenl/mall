package com.cskaoyan.service.impl.shopImpl;

import com.cskaoyan.bean.ListBean;
import com.cskaoyan.bean.shop.order.*;
import com.cskaoyan.mapper.shopMapper.OrderGoodsMapper4Shop;
import com.cskaoyan.mapper.shopMapper.OrderMapper4Shop;
import com.cskaoyan.mapper.shopMapper.UserMapper4Shop;
import com.cskaoyan.service.shopService.OrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper4Shop orderMapper4Shop;

    @Autowired
    OrderGoodsMapper4Shop orderGoodsMapper4Shop;

    @Autowired
    UserMapper4Shop userMapper4Shop;

    @Override
    public ListBean list(Short[] orderStatusArray, Integer userId, String orderSn, Integer page, Integer limit, String sort, String order) {
        PageHelper.startPage(page,limit);

        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria = orderExample.createCriteria();

        if (orderStatusArray != null){
            List<Short> list = Arrays.asList(orderStatusArray);
            criteria.andOrderStatusIn(list);
        }
        if (userId != null){
            criteria.andUserIdEqualTo(userId);
        }
        if (orderSn != "" && orderSn != null){
            criteria.andOrderSnEqualTo(orderSn);
        }

        orderExample.setOrderByClause(sort + " " + order);
        List<Order> orders = orderMapper4Shop.selectByExample(orderExample);

        PageInfo pageInfo = new PageInfo(orders);
        long total = pageInfo.getTotal();

        ListBean listBean = new ListBean();
        listBean.setItems(orders);
        listBean.setTotal(total);
        return listBean;
    }

    @Override
    public OrderListBean detail(Integer id) {
        Order order = orderMapper4Shop.selectByPrimaryKey(id);
        OrderGoodsExample orderGoodsExample = new OrderGoodsExample();
        orderGoodsExample.createCriteria().andOrderIdEqualTo(id);
        List<OrderGoods> orderGoods = orderGoodsMapper4Shop.selectByExample(orderGoodsExample);
        User user = userMapper4Shop.selectByPrimaryKey(order.getUserId());

        OrderListBean orderListBean = new OrderListBean();
        orderListBean.setOrder(order);
        orderListBean.setOrderGoods(orderGoods);
        orderListBean.setUser(user);
        return orderListBean;
    }

    @Override
    @Transactional
    public void ship(ShipBO shipBO) {
        Order record = new Order();
        record.setId(shipBO.getOrderId());
        record.setShipChannel(shipBO.getShipChannel());
        record.setShipSn(shipBO.getShipSn());
        record.setOrderStatus((short) 301);

        OrderExample orderExample = new OrderExample();
        orderExample.createCriteria().andIdEqualTo(shipBO.getOrderId());

        orderMapper4Shop.updateByExampleSelective(record,orderExample);
    }

    //TODO 退款功能未完全实现，需要与小程序对接
    @Override
    @Transactional
    public void refund(RefundBO refundBO) {
        Order record = new Order();
        record.setId(refundBO.getOrderId());
        record.setOrderStatus((short) 203);

        OrderExample orderExample = new OrderExample();
        orderExample.createCriteria().andIdEqualTo(refundBO.getOrderId());

        orderMapper4Shop.updateByExampleSelective(record,orderExample);
    }
}
