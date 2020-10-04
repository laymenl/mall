package com.cskaoyan.controller;

import com.cskaoyan.bean.BaseRespVo;
import com.cskaoyan.bean.ListBean;
import com.cskaoyan.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin/log")
public class LogController {
    @Autowired
    LogService logService;

    @RequestMapping("list")
    public BaseRespVo list(String name, Integer page, Integer limit, String sort, String order){
        ListBean listBean = logService.queryLogListBean(name, page, limit, sort, order);
        return BaseRespVo.ok(listBean);
    }

}
