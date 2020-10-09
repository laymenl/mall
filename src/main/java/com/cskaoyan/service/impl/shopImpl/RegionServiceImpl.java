package com.cskaoyan.service.impl.shopImpl;

import com.cskaoyan.bean.shop.region.Province;
<<<<<<< HEAD
import com.cskaoyan.bean.shop.region.Region;
=======
>>>>>>> 1109be14e2f4f112ea4ce734cadacdfd8abca678
import com.cskaoyan.mapper.shopMapper.RegionMapper4Shop;
import com.cskaoyan.service.shopService.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionServiceImpl implements RegionService {

    @Autowired
    RegionMapper4Shop regionMapper;
<<<<<<< HEAD


=======
>>>>>>> 1109be14e2f4f112ea4ce734cadacdfd8abca678
    @Override
    public List<Province> getList() {
        List<Province> list =regionMapper.getList();
        return list;
    }
<<<<<<< HEAD

    @Override
    public List<Region> getRegionList(Integer pid) {
        List<Region> list  = regionMapper.getListByPid(pid);
        return list;
    }
=======
>>>>>>> 1109be14e2f4f112ea4ce734cadacdfd8abca678
}
