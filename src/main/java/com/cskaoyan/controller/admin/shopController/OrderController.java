package com.cskaoyan.controller.admin.shopController;

import com.cskaoyan.bean.BaseRespVo;
import com.cskaoyan.bean.ListBean;
import com.cskaoyan.bean.shop.order.OrderListBean;
import com.cskaoyan.bean.shop.order.RefundBO;
import com.cskaoyan.bean.shop.order.ShipBO;
import com.cskaoyan.service.shopService.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("admin/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping("list")
    public BaseRespVo list(Short[] orderStatusArray, Integer userId, String orderSn, Integer page, Integer limit, String sort, String order){
        ListBean listBean = orderService.list(orderStatusArray,userId,orderSn,page,limit,sort,order);
        return BaseRespVo.ok(listBean);
    }

    @RequestMapping("detail")
    public BaseRespVo detail(Integer id){
        OrderListBean orderListBean = orderService.detail(id);
        return BaseRespVo.ok(orderListBean);
    }

    @RequestMapping(value = "ship",method = RequestMethod.POST)
    public BaseRespVo ship(@RequestBody ShipBO shipBO){
        orderService.ship(shipBO);
        return BaseRespVo.ok();
    }
    @RequestMapping(value = "refund",method = RequestMethod.POST)
    public BaseRespVo refund(@RequestBody RefundBO refundBO){
        orderService.refund(refundBO);
        return BaseRespVo.ok();
    }
}
