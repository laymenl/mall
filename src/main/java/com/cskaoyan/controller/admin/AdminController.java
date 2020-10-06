package com.cskaoyan.controller.admin;

import com.cskaoyan.bean.SystemPart.Admin;
import com.cskaoyan.bean.BaseRespVo;
import com.cskaoyan.bean.ListBean;
import com.cskaoyan.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @RequestMapping("list")
    public BaseRespVo list(String username, Integer page, Integer limit, String sort, String order){
        ListBean listBean = adminService.queryAdminListBean(username, page,limit,sort,order);
        return BaseRespVo.ok(listBean);
    }

    @RequestMapping("create")
    public BaseRespVo create(@RequestBody Admin admin){
        adminService.createAdmin(admin);
        return BaseRespVo.ok(admin);
    }

    @RequestMapping("update")
    public BaseRespVo update(@RequestBody Admin admin){
        adminService.updateAdmin(admin);
        return BaseRespVo.ok(admin);
    }

    @RequestMapping("delete")
    public BaseRespVo delete(@RequestBody Admin admin){
        adminService.deleteAdmin(admin);
        return BaseRespVo.ok();
    }


}
