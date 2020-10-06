package com.cskaoyan.controller;

import com.cskaoyan.bean.BaseRespVo;
import com.cskaoyan.bean.DashBoardVO;
import com.cskaoyan.service.DashBoradService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashBoradController {

    @Autowired
    DashBoradService dashBoradService;

    @RequestMapping("/admin/dashboard")
    public BaseRespVo dashBoard(){
        DashBoardVO dashBoardVO = dashBoradService.dashBoard();
        return BaseRespVo.ok(dashBoardVO);
    }

}
