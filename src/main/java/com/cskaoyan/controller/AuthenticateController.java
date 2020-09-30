package com.cskaoyan.controller;

import com.cskaoyan.bean.BaseRespVo;
import com.cskaoyan.bean.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin/auth")
public class AuthenticateController {

    @RequestMapping("login")
    public BaseRespVo login(@RequestBody User user){
        //登录的业务逻辑使用shiro来做 →
        return BaseRespVo.ok("4e295462-c349-461a-8e79-e8147ca1ff1a");
    }
}
