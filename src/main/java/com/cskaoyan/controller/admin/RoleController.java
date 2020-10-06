package com.cskaoyan.controller.admin;

import com.cskaoyan.bean.SystemPart.Role;
import com.cskaoyan.bean.BaseRespVo;
import com.cskaoyan.bean.ListBean;
import com.cskaoyan.bean.SystemPart.VO.OptionVO;
import com.cskaoyan.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping("create")
    public BaseRespVo create(@RequestBody Role role){
        roleService.createRole(role);
        return BaseRespVo.ok(role);
    }

    @RequestMapping("update")
    public BaseRespVo update(@RequestBody Role role){
        roleService.updateRole(role);
        return BaseRespVo.ok(role);
    }

    @RequestMapping("delete")
    public BaseRespVo delete(@RequestBody Role role){
        roleService.deleteRole(role);
        return BaseRespVo.ok();
    }

    @RequestMapping("permissions")
    public BaseRespVo permissions(String roleId){
        System.out.println(roleId);
        return BaseRespVo.ok();
    }

}
