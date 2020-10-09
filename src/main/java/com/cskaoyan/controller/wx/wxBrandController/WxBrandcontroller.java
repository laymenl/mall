package com.cskaoyan.controller.wx.wxBrandController;

import com.cskaoyan.bean.BaseRespVo;
import com.cskaoyan.bean.shop.brand.Brand;
<<<<<<< HEAD
import com.cskaoyan.bean.wxvo.BrandVO;
=======
>>>>>>> 1109be14e2f4f112ea4ce734cadacdfd8abca678
import com.cskaoyan.bean.wxvo.wxBrandListVO;
import com.cskaoyan.service.shopService.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("wx/brand")
public class WxBrandcontroller {

    @Autowired
    BrandService brandService;

    @RequestMapping("list")
    public BaseRespVo list(Integer page, Integer size) {
        wxBrandListVO wxBrandListVO = brandService.queryBrandsList(page, size);
        return BaseRespVo.ok(wxBrandListVO);
    }

    @RequestMapping("detail")
    public BaseRespVo detail(Integer id) {
        Brand brand = brandService.queryBrandInfo(id);
<<<<<<< HEAD
        BrandVO brandVO = new BrandVO(brand);
        return BaseRespVo.ok(brandVO);
=======
        return BaseRespVo.ok(brand);
>>>>>>> 1109be14e2f4f112ea4ce734cadacdfd8abca678
    }
}
