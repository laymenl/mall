package com.cskaoyan.controller.wx;

import com.cskaoyan.bean.BaseRespVo;
import com.cskaoyan.bean.ListBean;
import com.cskaoyan.bean.OrderPart.OrderGoods;
import com.cskaoyan.bean.orderCancelBO;
import com.cskaoyan.bean.wxvo.WxOrderDetailVO;
import com.cskaoyan.bean.wxvo.WxOrderListVO;
import com.cskaoyan.service.wx.WxOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wx/order")
public class WxOrderController {

    @Autowired
    WxOrderService wxOrderService;

    @RequestMapping("list")
    public BaseRespVo list(Integer showType, Integer page, Integer size){
        WxOrderListVO list = wxOrderService.list(showType, page, size);
        return BaseRespVo.ok(list);
    }

    @RequestMapping("detail")
    public BaseRespVo detail(Integer orderId){
        System.out.println(orderId);
        WxOrderDetailVO detail = wxOrderService.detail(orderId);
        return BaseRespVo.ok(detail);
    }

    @RequestMapping("cancel")
    public BaseRespVo cancel(@RequestBody orderCancelBO orderCancelBO){
        Integer orderID = orderCancelBO.getOrderId();
        System.out.println(orderID);
        wxOrderService.cancel(orderID);
        return BaseRespVo.ok();
    }

    @RequestMapping("prepay")
    public BaseRespVo prepay(@RequestBody orderCancelBO orderCancelBO){
        Integer orderID = orderCancelBO.getOrderId();
        System.out.println(orderID);
        wxOrderService.prepay(orderID);
        return BaseRespVo.ok();
    }

    @RequestMapping("refund")
    public BaseRespVo refund(@RequestBody orderCancelBO orderCancelBO){
        Integer orderID = orderCancelBO.getOrderId();
        System.out.println(orderID);
        wxOrderService.refund(orderID);
        return BaseRespVo.ok();
    }

    @RequestMapping("delete")
    public BaseRespVo delete(@RequestBody orderCancelBO orderCancelBO){
        Integer orderID = orderCancelBO.getOrderId();
        System.out.println(orderID);
        wxOrderService.delete(orderID);
        return BaseRespVo.ok();
    }
    @RequestMapping("confirm")
    public BaseRespVo confirm(@RequestBody orderCancelBO orderCancelBO){
        Integer orderID = orderCancelBO.getOrderId();
        System.out.println(orderID);
        wxOrderService.confirm(orderID);
        return BaseRespVo.ok();
    }
    @RequestMapping("goods")
    public BaseRespVo goods(Integer orderId, Integer goodsId){
        System.out.println(orderId);
        System.out.println(goodsId);
        OrderGoods goods = wxOrderService.goods(orderId, goodsId);
        return BaseRespVo.ok(goods);
    }

}
