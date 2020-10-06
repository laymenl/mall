package com.cskaoyan.controller;

import com.cskaoyan.bean.BaseRespVo;
import com.cskaoyan.service.SystemConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("admin/{condition}")
public class ConfigController {
    @Autowired
    SystemConfigService systemConfigService;
    @RequestMapping("{condition}")
    public BaseRespVo mall(@PathVariable String condition){
        Map mallconfig = systemConfigService.selectByKey_name(condition);
        return BaseRespVo.ok(mallconfig);
    }
}
