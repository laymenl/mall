package com.cskaoyan.promoteModule.adManage.service;

import com.cskaoyan.promoteModule.adManage.bean.Ad;
import com.cskaoyan.promoteModule.adManage.bean.ListBean;

public interface AdService {
    ListBean queryAdListBean(Integer page, Integer limit, String sort, String order);

    Ad create(Ad ad);

    Ad update(Ad ad);

    int delete(Ad ad);
}
