package com.cskaoyan.service;

import com.cskaoyan.bean.stat.VO.StatVO;

public interface StatService {
    StatVO QueryUser();

    StatVO QueryOrder();

    StatVO QueryGoods();
}
