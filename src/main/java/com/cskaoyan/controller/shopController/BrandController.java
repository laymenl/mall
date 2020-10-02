package com.cskaoyan.controller.shopController;

import com.cskaoyan.bean.BaseRespVo;
import com.cskaoyan.bean.ListBean;
import com.cskaoyan.bean.shop.brand.Brand;
import com.cskaoyan.bean.shop.brand.BrandVO;
import com.cskaoyan.service.shopService.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin/brand")
public class BrandController {

    @Autowired
    BrandService brandService;

    @RequestMapping("list")
    public BaseRespVo list(Integer id, String name, Integer page, Integer limit, String sort, String order){
        ListBean listBean = brandService.queryBrandsListBean(id,name,page, limit, sort, order);
        return BaseRespVo.ok(listBean);
    }

    @RequestMapping(value = "create",method = RequestMethod.POST)
    public BaseRespVo create(@RequestBody Brand brand){
        BrandVO brandVO = brandService.createBrand(brand);
        return BaseRespVo.ok(brandVO);
    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public BaseRespVo update(@RequestBody Brand brand){
        BrandVO brandVO = brandService.updateBrand(brand);
        return BaseRespVo.ok(brandVO);
    }
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public BaseRespVo delete(@RequestBody Brand brand){
        brandService.deleteBrand(brand);
        return BaseRespVo.ok();
    }
}
