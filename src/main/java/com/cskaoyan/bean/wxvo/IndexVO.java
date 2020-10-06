package com.cskaoyan.bean.wxvo;

import com.cskaoyan.bean.GoodsPart.Goods;
import com.cskaoyan.bean.shop.brand.Brand;
import com.cskaoyan.bean.shop.category.Category;
import com.cskaoyan.promoteModule.adManage.bean.Ad;
import com.cskaoyan.promoteModule.couponManage.bean.Coupon;
import com.cskaoyan.promoteModule.grouponManage.bean.listRecord.Groupon;
import com.cskaoyan.promoteModule.topicManage.bean.Topic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IndexVO {
    List<Goods> newGoodsList;
    List<Coupon> couponList;
    List<Category> channel;
    List<Groupon> grouponList;
    List<Ad> banner;
    List<Brand> brandList;
    List<Goods> hotGoodsList;
    List<Topic> topicList;
    List floorGoodsList;
}
