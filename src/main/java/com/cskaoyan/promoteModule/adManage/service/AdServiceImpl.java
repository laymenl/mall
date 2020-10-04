package com.cskaoyan.promoteModule.adManage.service;

import com.cskaoyan.mapper.promoteModule.AdMapper;
import com.cskaoyan.promoteModule.adManage.bean.Ad;
import com.cskaoyan.promoteModule.adManage.bean.AdExample;
import com.cskaoyan.promoteModule.adManage.bean.ListBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class AdServiceImpl implements AdService {

    @Autowired
    AdMapper adMapper;

    @Override
    public ListBean queryAdListBean(Integer page, Integer limit, String sort, String order) {
        // 分页  --> 在预编译过程中自动添加偏移量的SQL语句
        PageHelper.startPage(page, limit);

        // example 是提供条件的
        AdExample adExample = new AdExample();

        // criteria 就是条件（判断的准则）
        // and + 列名 + 条件   adExample.createCriteria().andAddTime Between();
        adExample.createCriteria();

        // 排序
        adExample.setOrderByClause(sort + " " + order);
        List<Ad> ads = adMapper.selectByExample(adExample);
        for (Ad ad : ads) {
            System.out.println("查询到的ad：" + ad);
        }

        // 分页信息
        PageInfo pageInfo = new PageInfo(ads);
        long total = pageInfo.getTotal();

        ListBean listBean = new ListBean();
        listBean.setItems(ads);
        listBean.setTotal(total);

        return listBean;
    }

    @SneakyThrows
    @Override
    public Ad create(Ad ad) {
        if (ad.getLink() == null){
            ad.setLink("");
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        String date = simpleDateFormat.format(new Date());
        Date updateTime = simpleDateFormat.parse(date);
        Date addTime = updateTime;

        ad.setAddTime(addTime);
        ad.setUpdateTime(updateTime);

        adMapper.insert(ad);
        AdExample adExample = new AdExample();
        adExample.createCriteria().andUrlEqualTo(ad.getUrl());
        List<Ad> ads = adMapper.selectByExample(adExample);
        return ads.get(0);
    }


    @SneakyThrows
    @Override
    public Ad update(Ad ad) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        String date = simpleDateFormat.format(new Date());
        Date updateTime = simpleDateFormat.parse(date);
        ad.setUpdateTime(updateTime);

        adMapper.updateByPrimaryKeySelective(ad);
        AdExample adExample = new AdExample();
        adExample.createCriteria().andIdEqualTo(ad.getId());
        List<Ad> ads = adMapper.selectByExample(adExample);
        return ads.get(0);
    }

    @Override
    public int delete(Ad ad) {
        int status = adMapper.deleteByPrimaryKey(ad.getId());
        return status;
    }
}
