package com.cskaoyan.controller;

import com.cskaoyan.bean.BaseRespVo;
import com.cskaoyan.bean.stat.VO.StatVO;
import com.cskaoyan.service.StatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin/stat")
public class StatController {

    @Autowired
    StatService statService;

    @RequestMapping("user")
    public BaseRespVo user() {
        StatVO statVO = statService.QueryUser();
        return BaseRespVo.ok(statVO);
    }

    @RequestMapping("order")
    public BaseRespVo order() {
        StatVO statVO = statService.QueryOrder();

        return BaseRespVo.ok(statVO);
    }

    @RequestMapping("goods")
    public BaseRespVo goods() {
        StatVO statVO = statService.QueryGoods();

        return BaseRespVo.ok(statVO);
    }
}
