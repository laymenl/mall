package com.cskaoyan.service.impl;

import com.cskaoyan.bean.ListBean;
import com.cskaoyan.bean.SystemPart.Log;
import com.cskaoyan.bean.SystemPart.LogExample;
import com.cskaoyan.mapper.LogMapper;
import com.cskaoyan.service.LogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    LogMapper logMapper;

    @Override
    public ListBean queryLogListBean(String name, Integer page, Integer limit, String sort, String order) {
        PageHelper.startPage(page,limit);
        LogExample logExample = new LogExample();
        LogExample.Criteria criteria = logExample.createCriteria();
        if(name != null){
            criteria.andAdminLike("%"+name+"%");
        }
        logExample.setOrderByClause(sort + " " + order);
        List<Log> logs = logMapper.selectByExample(logExample);
        PageInfo pageInfo = new PageInfo(logs);
        long total = pageInfo.getTotal();
        ListBean listBean = new ListBean();
        listBean.setItems(logs);
        listBean.setTotal(total);
        return listBean;
    }
}
