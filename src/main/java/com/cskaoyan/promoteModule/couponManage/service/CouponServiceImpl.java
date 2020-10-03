package com.cskaoyan.promoteModule.couponManage.service;

import com.cskaoyan.mapper.promoteModule.CouponMapper;
import com.cskaoyan.promoteModule.couponManage.bean.Coupon;
import com.cskaoyan.promoteModule.couponManage.bean.CouponExample;
import com.cskaoyan.promoteModule.couponManage.bean.ListBean;
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
public class CouponServiceImpl implements CouponService{

    @Autowired
    CouponMapper couponMapper;

    @Override
    public ListBean queryCouponListBean(Integer page, Integer limit, String sort, String order) {
        PageHelper.startPage(page, limit);

        CouponExample couponExample = new CouponExample();
        couponExample.createCriteria();

        couponExample.setOrderByClause(sort + " " + order);
        List<Coupon> coupons = couponMapper.selectByExample(couponExample);
        for (Coupon couponUser : coupons) {
            System.out.println("查询到的coupon：" + coupons);
        }

        PageInfo pageInfo = new PageInfo(coupons);
        long total = pageInfo.getTotal();

        ListBean listBean = new ListBean();
        listBean.setItems(coupons);
        listBean.setTotal(total);

        return listBean;
    }


    @SneakyThrows
    @Override
    public Coupon create(Coupon coupon) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        String date = simpleDateFormat.format(new Date());
        Date updateTime = simpleDateFormat.parse(date);
        Date addTime = updateTime;

        coupon.setAddTime(addTime);
        coupon.setUpdateTime(updateTime);

        if (coupon.getDesc()==null){
            coupon.setDesc("");
        }
        if (coupon.getTag()==null){
            coupon.setTag("");
        }
        couponMapper.insert(coupon);

        CouponExample couponExample = new CouponExample();
        couponExample.createCriteria().andNameEqualTo(coupon.getName()).andAddTimeEqualTo(coupon.getAddTime());

        List<Coupon> coupons = couponMapper.selectByExample(couponExample);
        return coupons.get(0);
    }

    @SneakyThrows
    @Override
    public Coupon update(Coupon coupon) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        String date = simpleDateFormat.format(new Date());
        Date updateTime = simpleDateFormat.parse(date);
        coupon.setUpdateTime(updateTime);

        couponMapper.updateByPrimaryKeySelective(coupon);
        CouponExample couponExample = new CouponExample();
        couponExample.createCriteria().andIdEqualTo(coupon.getId());
        List<Coupon> coupons = couponMapper.selectByExample(couponExample);
        return coupons.get(0);
    }

    @Override
    public int delete(Coupon coupon) {
        int status = couponMapper.deleteByPrimaryKey(coupon.getId());
        return status;
    }
}
