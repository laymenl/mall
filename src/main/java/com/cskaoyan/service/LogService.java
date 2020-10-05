package com.cskaoyan.service;

import com.cskaoyan.bean.ListBean;

public interface LogService {
    ListBean queryLogListBean(String name, Integer page, Integer limit, String sort, String order);
}
