package com.cskaoyan.service.impl;

import com.cskaoyan.bean.AdminPart.Admin;
import com.cskaoyan.bean.AdminPart.AdminExample;
import com.cskaoyan.bean.ListBean;
import com.cskaoyan.mapper.AdminMapper;
import com.cskaoyan.service.AdminService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;
    @Override
    public ListBean queryAdminListBean(String username, Integer page, Integer limit, String sort, String order) {
        PageHelper.startPage(page,limit);
        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();
        if(username != null){
            criteria.andUsernameLike("%"+username+"%");
        }
        adminExample.setOrderByClause(sort + " " + order);
        List<Admin> admins = adminMapper.selectByExample(adminExample);
        PageInfo pageInfo = new PageInfo(admins);
        long total = pageInfo.getTotal();
        ListBean listBean = new ListBean();
        listBean.setItems(admins);
        listBean.setTotal(total);
        return listBean;
    }

    @Override
    public void createAdmin(Admin admin) {

        admin.setAddTime(new Date());
        admin.setUpdateTime(new Date());
        admin.setDeleted(false);
        adminMapper.insert(admin);
    }

    @Override
    public void updateAdmin(Admin admin) {
        admin.setUpdateTime(new Date());
        adminMapper.updateByPrimaryKey(admin);
    }

    @Override
    public void deleteAdmin(Admin admin) {
        adminMapper.deleteByPrimaryKey(admin.getId());
    }
}
