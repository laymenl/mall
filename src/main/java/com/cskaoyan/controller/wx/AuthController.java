package com.cskaoyan.controller.wx;

import com.cskaoyan.bean.BaseRespVo;
import com.cskaoyan.bean.wxvo.LoginVO;
import com.cskaoyan.bean.wxvo.UserInfoVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wx/auth")
public class AuthController {

    @RequestMapping("login")
    public BaseRespVo login(){
        UserInfoVO userInfoVO = new UserInfoVO("test1",
                "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif?imageView2/1/w/80/h/80");
        LoginVO loginVO = new LoginVO(userInfoVO, "2020-10-07T18:05:53.965", "fbqj3vfhe21xzachjt4i8sgec5rkjiuc");
        return BaseRespVo.ok(loginVO);
    }
}
