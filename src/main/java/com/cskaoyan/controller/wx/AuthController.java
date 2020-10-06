package com.cskaoyan.controller.wx;

import com.cskaoyan.bean.BaseRespVo;
import com.cskaoyan.bean.User;
import com.cskaoyan.bean.UserExample;
import com.cskaoyan.bean.wxvo.LoginVO;
import com.cskaoyan.bean.wxvo.UserInfoVO;
import com.cskaoyan.mapper.UserMapper;
import com.cskaoyan.service.wx.AuthService;
import com.cskaoyan.shiro.MallToken;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/wx/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @RequestMapping("login")
    public BaseRespVo login(@RequestBody User user){
//        UserInfoVO userInfoVO = new UserInfoVO("test1",
//                "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif?imageView2/1/w/80/h/80");
//        LoginVO loginVO = new LoginVO(userInfoVO, "2020-10-07T18:05:53.965", "fbqj3vfhe21xzachjt4i8sgec5rkjiuc");
//        return BaseRespVo.ok(loginVO);
        Subject subject = SecurityUtils.getSubject();
        MallToken token = new MallToken(user.getUsername(), user.getPassword(), "wx");
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            return BaseRespVo.fail("登陆失败，请检查账号和密码");
        }
        String tokenId = (String) subject.getSession().getId();
        LoginVO loginVO = authService.login(tokenId, user);
        return BaseRespVo.ok(loginVO);
    }

    @RequestMapping("logout")
    public BaseRespVo logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return BaseRespVo.ok();
    }
}
