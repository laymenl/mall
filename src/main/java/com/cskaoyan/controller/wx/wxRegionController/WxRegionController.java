package com.cskaoyan.controller.wx.wxRegionController;

import com.cskaoyan.bean.BaseRespVo;
import com.cskaoyan.bean.shop.region.Province;
import com.cskaoyan.bean.shop.region.Region;
import com.cskaoyan.service.shopService.RegionService;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("wx/region")
public class WxRegionController {

    @Autowired
    RegionService regionService;

    @RequestMapping("list")
    public BaseRespVo list(Integer pid) {
        List<Region> list = regionService.getRegionList(pid);
        return BaseRespVo.ok(list);
    }
}
