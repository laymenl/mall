package com.cskaoyan.promoteModule.grouponManage.service;

import com.cskaoyan.promoteModule.grouponManage.bean.GrouponRules;
import com.cskaoyan.promoteModule.grouponManage.bean.ListBean;

public interface GrouponRulesService {
    ListBean queryGrouponRulesListBean(Integer page, Integer limit, String sort, String order);

    GrouponRules create(GrouponRules grouponRules);

    GrouponRules update(GrouponRules grouponRules);

    int delete(GrouponRules grouponRules);

    ListBean queryRecordListBean(Integer page, Integer limit, String sort, String order);
}
