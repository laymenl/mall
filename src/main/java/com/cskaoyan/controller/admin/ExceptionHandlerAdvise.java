package com.cskaoyan.controller.admin;

import com.cskaoyan.bean.BaseRespVo;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@ControllerAdvice
public class ExceptionHandlerAdvise {

    @ExceptionHandler(AuthorizationException.class)
    public BaseRespVo handlerAuthorException(Exception e){
        return BaseRespVo.fail("无权限");
    }

}
