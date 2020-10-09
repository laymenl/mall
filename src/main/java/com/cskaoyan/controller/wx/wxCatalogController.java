package com.cskaoyan.controller.wx;

import com.cskaoyan.bean.BaseRespVo;
import com.cskaoyan.bean.wxvo.CatalogVO;
import com.cskaoyan.bean.wxvo.CategoryCurrentVO;
import com.cskaoyan.service.wx.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("wx/catalog")
public class wxCatalogController {

    @Autowired
    CatalogService catalogService;

    @RequestMapping("index")
    public BaseRespVo index() {
        CatalogVO index = catalogService.index();
        return BaseRespVo.ok(index);
    }

    @RequestMapping("current")
    public BaseRespVo current(Integer id) {
        CategoryCurrentVO categoryCurrentVO = catalogService.current(id);
        return BaseRespVo.ok(categoryCurrentVO);
    }
}
