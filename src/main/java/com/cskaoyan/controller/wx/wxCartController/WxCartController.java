package com.cskaoyan.controller.wx.wxCartController;

import com.cskaoyan.bean.BaseRespVo;
import com.cskaoyan.bean.wxvo.cart.CartListBean;
import com.cskaoyan.service.wx.WxCartService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
