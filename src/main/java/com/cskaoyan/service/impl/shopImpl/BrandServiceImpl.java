package com.cskaoyan.service.impl.shopImpl;

import com.cskaoyan.bean.ListBean;
import com.cskaoyan.bean.shop.brand.Brand;
import com.cskaoyan.bean.shop.brand.BrandExample;
import com.cskaoyan.bean.shop.brand.BrandVO;
import com.cskaoyan.mapper.shopMapper.BrandMapper4Shop;
import com.cskaoyan.service.shopService.BrandService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    BrandMapper4Shop brandMapper;

    @Override
    public ListBean queryBrandsListBean(Integer id, String name, Integer page, Integer limit, String sort, String order) {
        PageHelper.startPage(page,limit);

        BrandExample brandExample = new BrandExample();
        BrandExample.Criteria criteria = brandExample.createCriteria();
        if (id != null){
            criteria.andIdEqualTo(id);
        }
        if(name != null){
            criteria.andNameLike("%"+ name +"%");
        }
        brandExample.setOrderByClause(sort + " " + order);
        List<Brand> brands = brandMapper.selectByExample(brandExample);

        PageInfo pageInfo = new PageInfo(brands);
        long total = pageInfo.getTotal();

        ListBean listBean = new ListBean();
        listBean.setItems(brands);
        listBean.setTotal(total);
        return listBean;
    }

    @Override
    public BrandVO createBrand(Brand brand) {
        //brand.setPicUrl("123");
        brand.setAddTime(new Date());
        brand.setUpdateTime(new Date());
        brandMapper.insertSelective(brand);
        int i = brandMapper.selectLastId();
        Brand brandSelectById = brandMapper.selectByPrimaryKey(i);
        return getBrandVO(brandSelectById);
    }

    @Override
    public BrandVO updateBrand(Brand brand) {
        BrandExample brandExample = new BrandExample();
        brandExample.createCriteria().andIdEqualTo(brand.getId());
        Brand record = new Brand();

        record.setUpdateTime(new Date());
        record.setName(brand.getName());
        record.setDesc(brand.getDesc());
        record.setPicUrl(brand.getPicUrl());
        record.setFloorPrice(brand.getFloorPrice());

        brandMapper.updateByExampleSelective(record,brandExample);
        Brand brandSelectById = brandMapper.selectByPrimaryKey(brand.getId());
        return getBrandVO(brandSelectById);
    }

    @Override
    public void deleteBrand(Brand brand) {
       brandMapper.deleteByPrimaryKey(brand.getId());
    }

    private BrandVO getBrandVO(Brand brand) {

        BrandVO brandVO = new BrandVO();

        brandVO.setId(brand.getId());
        brandVO.setAddTime(brand.getAddTime());
        brandVO.setDesc(brand.getDesc());
        brandVO.setUpdateTime(brand.getUpdateTime());
        brandVO.setFloorPrice(brand.getFloorPrice());
        brandVO.setPicUrl(brand.getPicUrl());
        brandVO.setName(brand.getName());
        return brandVO;
    }

}
