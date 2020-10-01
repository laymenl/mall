package com.cskaoyan.service;

import com.cskaoyan.bean.ListBean;

public interface GoodsService {
    ListBean queryGoodsListBean(Integer page, Integer limit, String sort, String order);
}
