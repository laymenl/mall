package com.cskaoyan.service.impl.shopImpl;

import com.cskaoyan.bean.ListBean;
import com.cskaoyan.bean.shop.brand.Brand;
import com.cskaoyan.bean.shop.brand.BrandExample;
import com.cskaoyan.bean.shop.brand.BrandVO;
import com.cskaoyan.bean.wxvo.wxBrandList;
import com.cskaoyan.bean.wxvo.wxBrandListVO;
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
        brandMapper.updateByExampleSelective(brand,brandExample);
        Brand brandSelectById = brandMapper.selectByPrimaryKey(brand.getId());
        return getBrandVO(brandSelectById);
    }

    @Override
    public void deleteBrand(Brand brand) {
       brandMapper.deleteByPrimaryKey(brand.getId());
    }

    @Override
    public wxBrandListVO queryBrandsList(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        List<wxBrandList> brands = brandMapper.selectBrandList();
        PageInfo pageInfo = new PageInfo(brands);
        long total = pageInfo.getTotal();
        wxBrandListVO wxBrandListVO = new wxBrandListVO();
        wxBrandListVO.setBrandList(brands);
        wxBrandListVO.setTotalPages(total);
        return wxBrandListVO;

    }

    @Override
    public Brand queryBrandInfo(Integer id) {
        Brand brand = brandMapper.selectByPrimaryKey(id);
        return brand;
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
