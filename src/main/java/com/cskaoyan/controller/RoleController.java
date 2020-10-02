package com.cskaoyan.controller;

import com.cskaoyan.bean.BaseRespVo;
import com.cskaoyan.bean.ListBean;
import com.cskaoyan.bean.AdminPart.VO.OptionVO;
import com.cskaoyan.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("admin/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @RequestMapping("list")
    public BaseRespVo list(String name, Integer page, Integer limit, String sort, String order){
        ListBean listBean = roleService.queryRoleListBean(name, page, limit, sort, order);
        return BaseRespVo.ok(listBean);
    }

    @RequestMapping("options")
    public BaseRespVo options(){
        List<OptionVO> optionVOList = roleService.queryOptions();
        return BaseRespVo.ok(optionVOList);
    }

}
