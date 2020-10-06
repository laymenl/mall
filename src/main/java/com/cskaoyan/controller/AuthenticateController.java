package com.cskaoyan.controller;

import com.cskaoyan.bean.BaseRespVo;
import com.cskaoyan.bean.DataBean;
import com.cskaoyan.bean.User;
import com.cskaoyan.shiro.MallToken;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.ArrayList;

@RestController
@RequestMapping("admin/auth")
public class AuthenticateController {

    @RequestMapping("login")
    public BaseRespVo login(@RequestBody User user) {
        Subject subject = SecurityUtils.getSubject();
        MallToken token = new MallToken(user.getUsername(), user.getPassword(), "admin");
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            return BaseRespVo.fail("登陆失败，请检查账号和密码");
        }
        String id = (String) subject.getSession().getId();
        return BaseRespVo.ok(id);
    }

    @RequestMapping("logout")
    public BaseRespVo logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return BaseRespVo.ok();
    }

    @RequestMapping("info")
    public BaseRespVo info(String token) {
        DataBean dataBean = new DataBean();
        dataBean.setAvatar("http://localhost:8083/images.png");
        dataBean.setName("admin");
        ArrayList<String> perms = new ArrayList<>();
        perms.add("*");
        dataBean.setPerms(perms);

        ArrayList<String> roles = new ArrayList<>();
        roles.add("超级管理员");
        dataBean.setRoles(roles);
        return BaseRespVo.ok(dataBean);
    }

}
