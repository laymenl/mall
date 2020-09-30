package com.cskaoyan.controller;

import com.cskaoyan.bean.BaseRespVo;
import com.cskaoyan.bean.DataBean;
import com.cskaoyan.bean.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("admin/auth")
public class AuthenticateController {

    @RequestMapping("login")
    public BaseRespVo login(@RequestBody User user) {
        //登录的业务逻辑使用shiro来做 →
        return BaseRespVo.ok("4e295462-c349-461a-8e79-e8147ca1ff1a");
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
