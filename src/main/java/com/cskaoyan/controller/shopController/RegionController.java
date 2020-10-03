package com.cskaoyan.controller.shopController;

import com.cskaoyan.bean.BaseRespVo;
import com.cskaoyan.bean.shop.region.Province;
import com.cskaoyan.service.shopService.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("admin/region")
public class RegionController {

    @Autowired
    RegionService regionService;

    @RequestMapping("list")
    public BaseRespVo list() {
        List<Province> list = regionService.getList();
        return BaseRespVo.ok(list);
    }
}
