package com.cskaoyan.service;

import com.cskaoyan.bean.ListBean;
import com.cskaoyan.bean.AdminPart.VO.OptionVO;

import java.util.List;

public interface RoleService {
    ListBean queryRoleListBean(String name, Integer page, Integer limit, String sort, String order);

    List<OptionVO> queryOptions();
}
