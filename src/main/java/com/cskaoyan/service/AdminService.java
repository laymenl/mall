package com.cskaoyan.service;

import com.cskaoyan.bean.ListBean;


public interface AdminService {
    ListBean queryAdminListBean(Integer page, Integer limit, String sort, String order);
}
