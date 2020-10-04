package com.cskaoyan.service.impl;

import com.cskaoyan.bean.ListBean;
import com.cskaoyan.bean.AdminPart.VO.OptionVO;
import com.cskaoyan.bean.AdminPart.Role;
import com.cskaoyan.bean.AdminPart.RoleExample;
import com.cskaoyan.mapper.RoleMapper;
import com.cskaoyan.service.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleMapper roleMapper;
    @Override
    public ListBean queryRoleListBean(String name, Integer page, Integer limit, String sort, String order) {
        PageHelper.startPage(page,limit);
        RoleExample roleExample = new RoleExample();
        RoleExample.Criteria criteria = roleExample.createCriteria();
        if(name != null){
            criteria.andNameLike("%"+name+"%");
        }
        roleExample.setOrderByClause(sort + " " + order);
        List<Role> roles = roleMapper.selectByExample(roleExample);
        PageInfo pageInfo = new PageInfo(roles);
        long total = pageInfo.getTotal();
        ListBean listBean = new ListBean();
        listBean.setItems(roles);
        listBean.setTotal(total);
        return listBean;
    }

    public List<OptionVO> queryOptions(){
        List<OptionVO> optionVOList = roleMapper.queryOptions();
        return optionVOList;
    }

    @Override
    public void createRole(Role role) {
        role.setAddTime(new Date());
        role.setUpdateTime(new Date());
        role.setDeleted(false);
        roleMapper.insert(role);
    }

    @Override
    public void updateRole(Role role) {
        role.setUpdateTime(new Date());
        roleMapper.updateByPrimaryKey(role);
    }

    @Override
    public void deleteRole(Role role) {
        roleMapper.deleteByPrimaryKey(role.getId());
    }
}
