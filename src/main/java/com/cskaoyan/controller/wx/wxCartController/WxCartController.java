package com.cskaoyan.controller.wx.wxCartController;

import com.cskaoyan.bean.BaseRespVo;
import com.cskaoyan.bean.wxvo.cart.*;
import com.cskaoyan.service.wx.WxCartService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("wx/cart")
public class WxCartController {
    @Autowired
    WxCartService wxCartService;

    @RequestMapping("index")
    public BaseRespVo index(){
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            String username = (String) subject.getPrincipals().getPrimaryPrincipal();
            System.out.println(username);
            CartListBean cartListBean = wxCartService.index(username);
            return BaseRespVo.ok(cartListBean);
        }else {
            return BaseRespVo.fail501("请登录");
        }
    }
    /*productId: 125
      goodsId: 1097011
      number: 11
      id: 227*/
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public BaseRespVo update(@RequestBody Cart cart){
        wxCartService.update(cart);
        return BaseRespVo.ok();
    }

    @RequestMapping("checked")
    public BaseRespVo checked(@RequestBody CartBO cartBO){
        Subject subject = SecurityUtils.getSubject();
        String username = (String) subject.getPrincipals().getPrimaryPrincipal();
        CartListBean cartListBean = wxCartService.checked(cartBO,username);
        return BaseRespVo.ok(cartListBean);
    }

    @RequestMapping("delete")
    public BaseRespVo delete(@RequestBody CartBO cartBO){
        Subject subject = SecurityUtils.getSubject();
        String username = (String) subject.getPrincipals().getPrimaryPrincipal();
        CartListBean cartListBean = wxCartService.delete(cartBO,username);
        return BaseRespVo.ok(cartListBean);
    }
    @RequestMapping("checkout")
    public BaseRespVo checkout(Integer cartId,Integer addressId,Integer couponId,Integer grouponRulesId){
        Subject subject = SecurityUtils.getSubject();
        String username = (String) subject.getPrincipals().getPrimaryPrincipal();
        CheckoutVO checkoutVO = wxCartService.checkout(username,cartId,addressId,couponId,grouponRulesId);
        return BaseRespVo.ok(checkoutVO);
    }
    @RequestMapping("goodscount")
    public BaseRespVo goodscount(){
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            String username = (String) subject.getPrincipals().getPrimaryPrincipal();
            Integer count = wxCartService.goodscount(username);
            return BaseRespVo.ok(count);
        }else{
            return BaseRespVo.ok(0);
        }
    }
    @RequestMapping("add")
    public BaseRespVo add(@RequestBody AddBO addBO){
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            String username = (String) subject.getPrincipals().getPrimaryPrincipal();
            int add = wxCartService.add(addBO, username);
            return BaseRespVo.ok(add);
        }else {
            return BaseRespVo.fail501("请登录");
        }
    }
    
}
