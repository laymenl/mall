package com.cskaoyan.service;

import com.cskaoyan.bean.AddressListBean;
import com.cskaoyan.bean.ListBean;
import com.cskaoyan.bean.UserAddress;
import com.cskaoyan.bean.collect.CollectListBean;
import com.cskaoyan.bean.collect.UserCollect;
import com.cskaoyan.bean.feedback.FeedBackListBean;
import com.cskaoyan.bean.footprint.FootPrintListBean;
import com.cskaoyan.bean.history.HistoryListBean;
import com.cskaoyan.bean.wxvo.CollectListVO;
import com.cskaoyan.bean.wxvo.UserAddressDetailVO;
import com.cskaoyan.bean.wxvo.UserAddressVO;

import java.util.HashMap;
import java.util.List;

public interface UserService {
    ListBean queryUserListBean(String username, String mobile, Integer page, Integer limit, String sort, String order);
    AddressListBean queryUserAddressListBean(String userId, String name, Integer page, Integer limit, String sort, String order);
    CollectListBean queryUserCollectListBean(Integer userId, Integer valueId, Integer page, Integer limit, String sort, String order);

    FootPrintListBean queryUserFootPrintListBean(Integer userId, Integer goodId, Integer page, Integer limit, String sort, String order);

    HistoryListBean queryUserSearchHistoryListBean(Integer userId, String keyword, Integer page, Integer limit, String sort, String order);

    FeedBackListBean queryUserFeedBackListBean(String username, Integer id, Integer page, Integer limit, String sort, String order);

    CollectListVO queryWxCollectListBean(Integer type, Integer page, Integer size);

    String addOrDeleteCollection(UserCollect userCollect);

    List<UserAddressVO> queryUserAddress();

    UserAddressDetailVO queryUserAddressDetail(Integer id);

    Integer saveUserAddress(UserAddress userAddress);

    Integer deleteUserAddress(HashMap id);
}
