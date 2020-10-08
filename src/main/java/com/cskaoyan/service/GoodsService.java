package com.cskaoyan.service;

import com.cskaoyan.bean.GoodsPart.Attribute;
import com.cskaoyan.bean.GoodsPart.VO.GoodsVO;
import com.cskaoyan.bean.GoodsPart.Goods;
import com.cskaoyan.bean.GoodsPart.Product;
import com.cskaoyan.bean.GoodsPart.Specification;
import com.cskaoyan.bean.GoodsPart.VO.CatAndBrandVO;
import com.cskaoyan.bean.ListBean;
import com.cskaoyan.bean.wxvo.GoodsDetailVO;
import com.cskaoyan.bean.wxvo.GoodsListVO;

import java.util.List;

public interface GoodsService {
    
    ListBean queryGoodsListBean(Integer page, Integer limit, String sort, String order, String goodsSn, String name);

    CatAndBrandVO catAndBrand();

    void create(Goods goods, List<Specification> specifications, List<Product> products, List<Attribute> attributes);

    GoodsVO detail(Integer id);

    void update(Goods goods, List<Specification> specifications, List<Product> products, List<Attribute> attributes);

    void delete(Integer id);

    int countTotal();

    List<Goods> related(Integer id);

    GoodsDetailVO wxDetail(int id);

    GoodsListVO list(Integer categoryId, Integer page, Integer size, String sort, String order, String keyword);
}
