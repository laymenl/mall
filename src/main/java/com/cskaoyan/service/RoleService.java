package com.cskaoyan.service;

import com.cskaoyan.bean.SystemPart.Role;
import com.cskaoyan.bean.ListBean;
import com.cskaoyan.bean.SystemPart.VO.OptionVO;

import java.util.List;

public interface RoleService {
    ListBean queryRoleListBean(String name, Integer page, Integer limit, String sort, String order);
    List<OptionVO> queryOptions();
    void createRole(Role role);
    void updateRole(Role role);
    void deleteRole(Role role);
}
