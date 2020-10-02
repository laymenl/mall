package com.cskaoyan.service.shopService;

import com.cskaoyan.bean.ListBean;
import com.cskaoyan.bean.shop.brand.Brand;
import com.cskaoyan.bean.shop.brand.BrandVO;

public interface BrandService {
    ListBean queryBrandsListBean(Integer id, String name, Integer page, Integer limit, String sort, String order);

    BrandVO createBrand(Brand brand);

    BrandVO updateBrand(Brand brand);

    void deleteBrand(Brand brand);
}
