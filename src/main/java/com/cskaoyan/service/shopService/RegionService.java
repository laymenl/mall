package com.cskaoyan.service.shopService;

import com.cskaoyan.bean.shop.region.Province;
import com.cskaoyan.bean.shop.region.Region;

import java.util.List;

public interface RegionService {
    List<Province> getList();

    List<Region> getRegionList(Integer pid);
}
