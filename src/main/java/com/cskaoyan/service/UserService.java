package com.cskaoyan.service;

import com.cskaoyan.bean.AddressListBean;
import com.cskaoyan.bean.ListBean;
import com.cskaoyan.bean.collect.CollectListBean;
import com.cskaoyan.bean.feedback.FeedBackListBean;
import com.cskaoyan.bean.footprint.FootPrintListBean;
import com.cskaoyan.bean.history.HistoryListBean;

public interface UserService {
    ListBean queryUserListBean(String username,String mobile,Integer page,Integer limit,String sort,String order);
    AddressListBean queryUserAddressListBean(Integer userId,String name,Integer page,Integer limit,String sort,String order);
    CollectListBean queryUserCollectListBean(Integer userId,Integer valueId,Integer page,Integer limit,String sort,String order);

    FootPrintListBean queryUserFootPrintListBean(Integer userId,Integer goodId,Integer page,Integer limit,String sort,String order);

    HistoryListBean queryUserSearchHistoryListBean(Integer userId,String keyword,Integer page,Integer limit,String sort,String order);

    FeedBackListBean queryUserFeedBackListBean(String username,Integer id,Integer page,Integer limit,String sort,String order);
}
