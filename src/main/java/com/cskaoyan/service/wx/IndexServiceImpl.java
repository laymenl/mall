package com.cskaoyan.service.wx;

import com.cskaoyan.bean.GoodsPart.Goods;
import com.cskaoyan.bean.GoodsPart.GoodsExample;
import com.cskaoyan.bean.shop.brand.Brand;
import com.cskaoyan.bean.shop.brand.BrandExample;
import com.cskaoyan.bean.shop.category.Category;
import com.cskaoyan.bean.shop.category.CategoryExample;
import com.cskaoyan.bean.wxvo.HomeIndexVO;
import com.cskaoyan.mapper.GoodsMapper;
import com.cskaoyan.mapper.promoteModule.AdMapper;
import com.cskaoyan.mapper.promoteModule.CouponMapper;
import com.cskaoyan.mapper.promoteModule.TopicMapper;
import com.cskaoyan.mapper.shopMapper.BrandMapper4Shop;
import com.cskaoyan.mapper.shopMapper.CategoryMapper4Shop;
import com.cskaoyan.promoteModule.adManage.bean.Ad;
import com.cskaoyan.promoteModule.adManage.bean.AdExample;
import com.cskaoyan.promoteModule.couponManage.bean.Coupon;
import com.cskaoyan.promoteModule.couponManage.bean.CouponExample;
import com.cskaoyan.promoteModule.topicManage.bean.Topic;
import com.cskaoyan.promoteModule.topicManage.bean.TopicExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexServiceImpl implements IndexService{

    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    CouponMapper couponMapper;

    @Autowired
    CategoryMapper4Shop categoryMapper;

    @Autowired
    AdMapper adMapper;

    @Autowired
    BrandMapper4Shop brandMapper;

    @Autowired
    TopicMapper topicMapper;

    @Override
    public HomeIndexVO index() {
        GoodsExample newGoodsExample = new GoodsExample();
        newGoodsExample.createCriteria().andIsNewEqualTo(true).andDeletedEqualTo(false);
        List<Goods> newGoods = goodsMapper.selectByExample(newGoodsExample);
        CouponExample couponExample = new CouponExample();
        couponExample.createCriteria().andDeletedEqualTo(false);
        List<Coupon> coupons = couponMapper.selectByExample(couponExample);
        CategoryExample categoryExample = new CategoryExample();
        categoryExample.createCriteria().andDeletedEqualTo(false).andLevelEqualTo("L1");
        List<Category> channel = categoryMapper.selectByExample(categoryExample);
        AdExample adExample = new AdExample();
        adExample.createCriteria().andDeletedEqualTo(false);
        List<Ad> banner = adMapper.selectByExample(adExample);
        BrandExample brandExample = new BrandExample();
        brandExample.createCriteria().andDeletedEqualTo(false);
        List<Brand> brandList = brandMapper.selectByExample(brandExample);
        GoodsExample hotGoodsExample = new GoodsExample();
        hotGoodsExample.createCriteria().andDeletedEqualTo(false).andIsHotEqualTo(true);
        List<Goods> hotGoodsList = goodsMapper.selectByExample(hotGoodsExample);
        TopicExample topicExample = new TopicExample();
        topicExample.createCriteria().andDeletedEqualTo(false);
        List<Topic> topicList = topicMapper.selectByExample(topicExample);
        //todo grouponlist and floorGoodsList
        HomeIndexVO homeIndexVO = new HomeIndexVO(newGoods, coupons, channel, null, banner, brandList, hotGoodsList, topicList, null);
        return homeIndexVO;
    }
}
