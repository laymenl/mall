package com.cskaoyan.controller.wx.wxCartController;

import com.cskaoyan.bean.BaseRespVo;
import com.cskaoyan.bean.wxvo.cart.Cart;
import com.cskaoyan.bean.wxvo.cart.CartListBean;
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
        String username = (String) subject.getPrincipals().getPrimaryPrincipal();
        //System.out.println(username);
        CartListBean cartListBean = wxCartService.index(username);
        return BaseRespVo.ok(cartListBean);
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
}
