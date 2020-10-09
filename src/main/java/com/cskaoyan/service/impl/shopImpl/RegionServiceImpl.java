package com.cskaoyan.service.impl.shopImpl;

import com.cskaoyan.bean.shop.region.Province;
import com.cskaoyan.bean.shop.region.Region;
import com.cskaoyan.mapper.shopMapper.RegionMapper4Shop;
import com.cskaoyan.service.shopService.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionServiceImpl implements RegionService {

    @Autowired
    RegionMapper4Shop regionMapper;


    @Override
    public List<Province> getList() {
        List<Province> list =regionMapper.getList();
        return list;
    }

    @Override
    public List<Region> getRegionList(Integer pid) {
        List<Region> list  = regionMapper.getListByPid(pid);
        return list;
    }
}
