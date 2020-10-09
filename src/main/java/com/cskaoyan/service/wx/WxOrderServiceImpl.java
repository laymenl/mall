package com.cskaoyan.service.wx;

import com.cskaoyan.bean.OrderPart.Order;
import com.cskaoyan.bean.OrderPart.OrderGoods;
import com.cskaoyan.bean.User;

import com.cskaoyan.bean.wxvo.*;
import com.cskaoyan.mapper.OrderGoodsMapper;
import com.cskaoyan.mapper.OrderMapper;
import com.cskaoyan.mapper.UserMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

@Service
public class WxOrderServiceImpl implements WxOrderService{
    @Autowired
    UserMapper userMapper;
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    OrderGoodsMapper orderGoodsMapper;

    @Override
    public WxOrderListVO list(Integer showType, Integer page, Integer size) {
        Subject subject = SecurityUtils.getSubject();
        String username = (String) subject.getPrincipals().getPrimaryPrincipal();
        com.cskaoyan.bean.UserExample userExample = new com.cskaoyan.bean.UserExample();
        userExample.createCriteria().andUsernameEqualTo(username);
        List<com.cskaoyan.bean.User> users = userMapper.selectByExample(userExample);
        Integer userID = users.size() >= 1 ? users.get(0).getId() : 0;
        if(showType == null){showType = 0;}
        List<WxOrderListData> wxOrderListDatas = orderMapper.selectWxOrderListDataByUserId(userID, showType);
        for(WxOrderListData wxOrderListData : wxOrderListDatas){
            com.cskaoyan.bean.OrderPart.Order order = orderMapper.selectByPrimaryKey(wxOrderListData.getId());
            BigDecimal grouponPrice = order.getGrouponPrice();
            if (grouponPrice.doubleValue() == 0.0) {
                wxOrderListData.setIsGroupin(false);
            }
            Short orderStatus = order.getOrderStatus();
            if (orderStatus == 101) {
<<<<<<< HEAD
                WxOrderListDataHandleOption wxOrderListDataHandleOption = new WxOrderListDataHandleOption(true, true, true, false, false, false, true);
=======

                WxOrderListDataHandleOption wxOrderListDataHandleOption = new WxOrderListDataHandleOption(true, false, true, false, false, false, true);
>>>>>>> 1109be14e2f4f112ea4ce734cadacdfd8abca678
                wxOrderListData.setOrderStatusText("未付款");
                wxOrderListData.setHandleOption(wxOrderListDataHandleOption);
            }

            if (orderStatus == 102) {
                wxOrderListData.setOrderStatusText("用户取消");
                WxOrderListDataHandleOption wxOrderListDataHandleOption = new WxOrderListDataHandleOption(false, true, false, false, false, false, true);
                wxOrderListData.setHandleOption(wxOrderListDataHandleOption);
            }
            if (orderStatus == 103) {
                wxOrderListData.setOrderStatusText("系统取消");
                WxOrderListDataHandleOption wxOrderListDataHandleOption = new WxOrderListDataHandleOption(false, true, false, false, false, false, true);
                wxOrderListData.setHandleOption(wxOrderListDataHandleOption);
            }
            if (orderStatus == 201) {
                wxOrderListData.setOrderStatusText("已付款");
<<<<<<< HEAD
                WxOrderListDataHandleOption wxOrderListDataHandleOption = new WxOrderListDataHandleOption(false, false, true, false, false, true, true);
=======
                WxOrderListDataHandleOption wxOrderListDataHandleOption = new WxOrderListDataHandleOption(false, false, false, false, false, true, true);
>>>>>>> 1109be14e2f4f112ea4ce734cadacdfd8abca678
                wxOrderListData.setHandleOption(wxOrderListDataHandleOption);
            }
            if (orderStatus == 202) {
                wxOrderListData.setOrderStatusText("申请退款");
<<<<<<< HEAD
                WxOrderListDataHandleOption wxOrderListDataHandleOption = new WxOrderListDataHandleOption(false, false, true, false, false, true, true);
                wxOrderListData.setHandleOption(wxOrderListDataHandleOption);
            }if (orderStatus == 203) {
                wxOrderListData.setOrderStatusText("已退款");
                WxOrderListDataHandleOption wxOrderListDataHandleOption = new WxOrderListDataHandleOption(false, true, true, false, false, true, true);
=======
                WxOrderListDataHandleOption wxOrderListDataHandleOption = new WxOrderListDataHandleOption(false, false, false, false, false, false, true);
                wxOrderListData.setHandleOption(wxOrderListDataHandleOption);
            }if (orderStatus == 203) {
                wxOrderListData.setOrderStatusText("已退款");
                WxOrderListDataHandleOption wxOrderListDataHandleOption = new WxOrderListDataHandleOption(false, true, false, false, false, false, true);
>>>>>>> 1109be14e2f4f112ea4ce734cadacdfd8abca678
                wxOrderListData.setHandleOption(wxOrderListDataHandleOption);
            }if (orderStatus == 301) {
                wxOrderListData.setOrderStatusText("已发货");
                WxOrderListDataHandleOption wxOrderListDataHandleOption = new WxOrderListDataHandleOption(false, false, false, false, true, true, true);
                wxOrderListData.setHandleOption(wxOrderListDataHandleOption);
            }
            if (orderStatus == 401) {
                wxOrderListData.setOrderStatusText("用户收货");
                WxOrderListDataHandleOption wxOrderListDataHandleOption = new WxOrderListDataHandleOption(false, false, false, true, false, true, true);
                wxOrderListData.setHandleOption(wxOrderListDataHandleOption);
            }if (orderStatus == 402) {
                wxOrderListData.setOrderStatusText("系统收货");
                WxOrderListDataHandleOption wxOrderListDataHandleOption = new WxOrderListDataHandleOption(false, false, false, true, false, true, true);
                wxOrderListData.setHandleOption(wxOrderListDataHandleOption);
            }

        }


        int size1 = wxOrderListDatas.size();
        WxOrderListVO wxOrderListVo = new WxOrderListVO();
        wxOrderListVo.setCount(size1);
        wxOrderListVo.setTotalPages(size1/size + 1);
        wxOrderListVo.setData(wxOrderListDatas);
        return wxOrderListVo;
    }

    @Override
    public WxOrderDetailVO detail(Integer orderId) {
        List<OrderGoods> orderGoods =new LinkedList<>();
        orderGoods.add(orderGoodsMapper.selectByPrimaryKey(orderId));
        WxOrderDetailVO wxOrderDetailVO = new WxOrderDetailVO();
        wxOrderDetailVO.setOrderGoods(orderGoods);
        OrderInfoVO orderInfoVO = orderMapper.selectOrderInfoByOrderId(orderId);
        System.out.println(orderInfoVO);
        Order order = orderMapper.selectByPrimaryKey(orderId);
        Short orderStatus = order.getOrderStatus();
        if (orderStatus == 101) {
<<<<<<< HEAD
            WxOrderListDataHandleOption wxOrderListDataHandleOption = new WxOrderListDataHandleOption(true, true, true, false, false, false, true);
=======
            WxOrderListDataHandleOption wxOrderListDataHandleOption = new WxOrderListDataHandleOption(true, false, true, false, false, false, true);
>>>>>>> 1109be14e2f4f112ea4ce734cadacdfd8abca678
            orderInfoVO.setOrderStatusText("未付款");
            orderInfoVO.setHandleOption(wxOrderListDataHandleOption);
        }
        if (orderStatus == 102) {
            orderInfoVO.setOrderStatusText("用户取消");
            WxOrderListDataHandleOption wxOrderListDataHandleOption = new WxOrderListDataHandleOption(false, true, false, false, false, false, true);
            orderInfoVO.setHandleOption(wxOrderListDataHandleOption);
        }
        if (orderStatus == 103) {
            orderInfoVO.setOrderStatusText("系统取消");
            WxOrderListDataHandleOption wxOrderListDataHandleOption = new WxOrderListDataHandleOption(false, true, false, false, false, false, true);
            orderInfoVO.setHandleOption(wxOrderListDataHandleOption);
        }
        if (orderStatus == 201) {
            orderInfoVO.setOrderStatusText("已付款");
<<<<<<< HEAD
            WxOrderListDataHandleOption wxOrderListDataHandleOption = new WxOrderListDataHandleOption(false, false, true, false, false, true, true);
=======
            WxOrderListDataHandleOption wxOrderListDataHandleOption = new WxOrderListDataHandleOption(false, false, false, false, false, true, true);
>>>>>>> 1109be14e2f4f112ea4ce734cadacdfd8abca678
            orderInfoVO.setHandleOption(wxOrderListDataHandleOption);
        }
        if (orderStatus == 202) {
            orderInfoVO.setOrderStatusText("申请退款");
<<<<<<< HEAD
            WxOrderListDataHandleOption wxOrderListDataHandleOption = new WxOrderListDataHandleOption(false, false, true, false, false, true, true);
            orderInfoVO.setHandleOption(wxOrderListDataHandleOption);
        }if (orderStatus == 203) {
            orderInfoVO.setOrderStatusText("已退款");
            WxOrderListDataHandleOption wxOrderListDataHandleOption = new WxOrderListDataHandleOption(false, true, true, false, false, true, true);
=======
            WxOrderListDataHandleOption wxOrderListDataHandleOption = new WxOrderListDataHandleOption(true, false, false, false, false, false, true);
            orderInfoVO.setHandleOption(wxOrderListDataHandleOption);
        }if (orderStatus == 203) {
            orderInfoVO.setOrderStatusText("已退款");
            WxOrderListDataHandleOption wxOrderListDataHandleOption = new WxOrderListDataHandleOption(false, true, false, false, false, false, true);
>>>>>>> 1109be14e2f4f112ea4ce734cadacdfd8abca678
            orderInfoVO.setHandleOption(wxOrderListDataHandleOption);
        }if (orderStatus == 301) {
            orderInfoVO.setOrderStatusText("已发货");
            WxOrderListDataHandleOption wxOrderListDataHandleOption = new WxOrderListDataHandleOption(false, false, false, false, true, true, true);
            orderInfoVO.setHandleOption(wxOrderListDataHandleOption);
        }
        if (orderStatus == 401) {
            orderInfoVO.setOrderStatusText("用户收货");
            WxOrderListDataHandleOption wxOrderListDataHandleOption = new WxOrderListDataHandleOption(false, false, false, true, false, true, true);
            orderInfoVO.setHandleOption(wxOrderListDataHandleOption);
        }if (orderStatus == 402) {
            orderInfoVO.setOrderStatusText("系统收货");
            WxOrderListDataHandleOption wxOrderListDataHandleOption = new WxOrderListDataHandleOption(false, false, false, true, false, true, true);
            orderInfoVO.setHandleOption(wxOrderListDataHandleOption);
        }



        wxOrderDetailVO.setOrderInfo(orderInfoVO);
        return wxOrderDetailVO;
    }

    @Override
    public void cancel(Integer orderId) {
<<<<<<< HEAD
        orderMapper.deleteByPrimaryKey(orderId);
=======
        Order order = orderMapper.selectByPrimaryKey(orderId);
        order.setOrderStatus((short)102);
        orderMapper.updateByPrimaryKey(order);
    }

    @Override
    public void prepay(Integer orderID) {
        Order order = orderMapper.selectByPrimaryKey(orderID);
        order.setOrderStatus((short)201);
        orderMapper.updateByPrimaryKey(order);
    }

    @Override
    public void refund(Integer orderID) {
        Order order = orderMapper.selectByPrimaryKey(orderID);
        order.setOrderStatus((short)203);
        orderMapper.updateByPrimaryKey(order);
    }

    @Override
    public void delete(Integer orderID) {
        orderMapper.deleteByPrimaryKey(orderID);
    }

    @Override
    public void confirm(Integer orderID) {
        Order order = orderMapper.selectByPrimaryKey(orderID);
        order.setOrderStatus((short)401);
        orderMapper.updateByPrimaryKey(order);
    }

    @Override
    public OrderGoods goods(Integer orderId, Integer goodsId) {
        OrderGoods orderGoods = orderGoodsMapper.selectByOrderIdAndGoodsId(orderId, goodsId);
        return orderGoods;


>>>>>>> 1109be14e2f4f112ea4ce734cadacdfd8abca678
    }
}
