package com.cskaoyan.controller.wx;

import com.cskaoyan.bean.BaseRespVo;
import com.cskaoyan.bean.wxvo.UserIndexVO;
import com.cskaoyan.service.shopService.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wx/user")
public class WxUserController {

    @Autowired
    OrderService orderService;

    @RequestMapping("/index")
    public BaseRespVo index(){
        UserIndexVO userIndexVO = orderService.wxUserIndex();
        return BaseRespVo.ok(userIndexVO);
    }

}
