package com.cskaoyan.wx_feedBack_footPrint_coupon_pic.couponManage.service;

import com.cskaoyan.bean.GoodsPart.Goods;
import com.cskaoyan.bean.User;
import com.cskaoyan.bean.UserExample;
import com.cskaoyan.bean.shop.category.Category;
import com.cskaoyan.bean.wxvo.UserInfoVO;
import com.cskaoyan.bean.wxvo.UserInfoVO;
import com.cskaoyan.mapper.CategoryMapper;
import com.cskaoyan.mapper.GoodsMapper;
import com.cskaoyan.mapper.UserMapper;
import com.cskaoyan.mapper.promoteModule.CouponMapper;
import com.cskaoyan.mapper.promoteModule.CouponUserMapper;
import com.cskaoyan.mapper.promoteModule.GrouponRulesMapper;
import com.cskaoyan.mapper.promoteModule.listRecord.GrouponMapper;
import com.cskaoyan.promoteModule.couponManage.bean.Coupon;
import com.cskaoyan.promoteModule.couponManage.bean.CouponExample;
import com.cskaoyan.promoteModule.couponManage.bean.CouponUser;
import com.cskaoyan.promoteModule.couponManage.bean.CouponUserExample;
import com.cskaoyan.promoteModule.grouponManage.bean.GrouponRules;

import com.cskaoyan.wx_feedBack_footPrint_coupon_pic.couponManage.bean.ListBean;
import com.cskaoyan.wx_feedBack_footPrint_coupon_pic.couponManage.bean.MyCouponVo;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.SneakyThrows;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class WxCouponServiceImpl implements WxCouponService {

    @Resource
    UserMapper userMapper;
    @Resource
    CouponMapper couponMapper;
    @Resource
    GrouponMapper grouponMapper;

    @Resource
    CouponUserMapper couponUserMapper;

    @Resource
    GoodsMapper goodsMapper;

    @Resource
    GrouponRulesMapper grouponRulesMapper;

    @Resource
    CategoryMapper categoryMapper;

    @Override
    public ListBean queryCouponListBean(Integer page, Integer size) {
        PageHelper.startPage(page, size);

        CouponExample couponExample = new CouponExample();
        couponExample.createCriteria();

        List<Coupon> coupons = couponMapper.selectByExample(couponExample);
        for (Coupon couponUser : coupons) {
            System.out.println("查询到的coupon：" + coupons);
        }

        PageInfo pageInfo = new PageInfo(coupons);
        long total = pageInfo.getTotal();

        ListBean listBean = new ListBean();
        listBean.setData(coupons);
        listBean.setCount(total);

        return listBean;
    }

    // myList
    @Override
    public ListBean queryMyCouponListBean(Short status, Integer page, Integer size) {
        List<Coupon> couponList = new ArrayList<>();

        PageHelper.startPage(page, size);

        Subject subject = SecurityUtils.getSubject();
        //String username = (String) subject.getPrincipals().getPrimaryPrincipal();

        String username = "test1";

        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username);
        User user = userMapper.selectByExample(userExample).get(0);


        CouponUserExample couponUserExample = new CouponUserExample();
        couponUserExample.createCriteria().andUserIdEqualTo(user.getId());
        List<CouponUser> couponUsers = couponUserMapper.selectByExample(couponUserExample);

        for (CouponUser couponUser : couponUsers) {

            Coupon coupon = couponMapper.selectByPrimaryKey(couponUser.getCouponId());
            if (coupon.getStatus() == status){
                couponList.add(coupon);
            }

        }


        PageInfo pageInfo = new PageInfo(couponList);
        long total = pageInfo.getTotal();

        ListBean listBean = new ListBean();
        listBean.setData(couponList);
        listBean.setCount(total);

        return listBean;

    }

    @Override
    public List queryCouponSelectListBean(Integer cardId, Integer grouponRulesId) {

        List<MyCouponVo> myCouponVoList = new ArrayList<>();


        Subject subject = SecurityUtils.getSubject();
        //String username = (String) subject.getPrincipals().getPrimaryPrincipal();

        String username = "test1";

        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username);
        User user = userMapper.selectByExample(userExample).get(0);


        CouponUserExample couponUserExample = new CouponUserExample();
        couponUserExample.createCriteria().andUserIdEqualTo(user.getId());
        List<CouponUser> couponUsers = couponUserMapper.selectByExample(couponUserExample);

        GrouponRules grouponRules = grouponRulesMapper.selectByPrimaryKey(grouponRulesId);

        Goods goods = goodsMapper.selectByPrimaryKey(grouponRules.getGoodsId());
        Category category = categoryMapper.selectByPrimaryKey(goods.getCategoryId());

        for (CouponUser couponUser : couponUsers) {
            Coupon coupon = couponMapper.selectByPrimaryKey(couponUser.getCouponId());
            MyCouponVo myCouponVo = new MyCouponVo(coupon.getId(),coupon.getName(),coupon.getDesc(),
                    coupon.getTag(),coupon.getMin(),coupon.getDiscount(),coupon.getStartTime(),coupon.getEndTime());
            if (coupon.getGoodsType() == 0){
                myCouponVoList.add(myCouponVo);
            }else if (coupon.getGoodsType()==1){
                if (Arrays.asList(coupon.getGoodsValue()).contains(category.getName())){
                    myCouponVoList.add(myCouponVo);
                }
            }else {
                if (Arrays.asList(coupon.getGoodsValue()).contains(grouponRules.getGoodsName())){
                    myCouponVoList.add(myCouponVo);
                }
            }

        }

        return myCouponVoList;
    }


    @SneakyThrows
    @Override
    public int receive(Integer couponId) {

        CouponUser couponUser = new CouponUser();


        Subject subject = SecurityUtils.getSubject();
        //String username = (String) subject.getPrincipals().getPrimaryPrincipal();

        String username = "test1";

        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username);
        User user = userMapper.selectByExample(userExample).get(0);

        couponUser.setUserId(user.getId());
        couponUser.setCouponId(couponId);

        Coupon coupon = couponMapper.selectByPrimaryKey(couponId);

        couponUser.setStatus(coupon.getStatus());
        couponUser.setStartTime(coupon.getStartTime());
        couponUser.setEndTime(coupon.getEndTime());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        String date = simpleDateFormat.format(new Date());
        Date updateTime = simpleDateFormat.parse(date);
        couponUser.setAddTime(updateTime);
        couponUser.setUpdateTime(updateTime);

        int receiveStatus = couponUserMapper.insert(couponUser);

        return receiveStatus;
    }


    @SneakyThrows
    @Override
    public int exchange(String code) {
        // 向 coupon_user中插入 数据
        CouponUser couponUser = new CouponUser();

        CouponExample couponExample = new CouponExample();
        couponExample.createCriteria().andCodeEqualTo(code);
        Coupon coupon = couponMapper.selectByExample(couponExample).get(0);

        Subject subject = SecurityUtils.getSubject();
        //String username = (String) subject.getPrincipals().getPrimaryPrincipal();

        String username = "test1";

        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username);
        User user = userMapper.selectByExample(userExample).get(0);

        couponUser.setUserId(user.getId());
        couponUser.setCouponId(coupon.getId());
        couponUser.setStatus(coupon.getStatus());
        couponUser.setStartTime(coupon.getStartTime());
        couponUser.setEndTime(coupon.getEndTime());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        String date = simpleDateFormat.format(new Date());
        Date updateTime = simpleDateFormat.parse(date);
        couponUser.setAddTime(updateTime);
        couponUser.setUpdateTime(updateTime);

        int receiveStatus = couponUserMapper.insert(couponUser);

        return receiveStatus;
    }

}
