package com.cskaoyan.controller.admin;

import com.cskaoyan.bean.BaseRespVo;
import com.cskaoyan.bean.DataBean;
import com.cskaoyan.bean.SystemPart.Admin;
import com.cskaoyan.bean.SystemPart.AdminExample;
import com.cskaoyan.bean.SystemPart.Role;
import com.cskaoyan.bean.SystemPart.RoleExample;
import com.cskaoyan.bean.User;
import com.cskaoyan.bean.UserExample;
import com.cskaoyan.mapper.AdminMapper;
import com.cskaoyan.mapper.PermissionMapper;
import com.cskaoyan.mapper.RoleMapper;
import com.cskaoyan.mapper.UserMapper;
import com.cskaoyan.shiro.MallToken;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("admin/auth")
public class AuthenticateController {

    @Autowired
    AdminMapper adminMapper;

    @Autowired
    PermissionMapper permissionMapper;

    @Autowired
    RoleMapper roleMapper;

    @RequestMapping("login")
    public BaseRespVo login(@RequestBody Admin admin) {
        Subject subject = SecurityUtils.getSubject();
        MallToken token = new MallToken(admin.getUsername(), admin.getPassword(), "admin");
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            return BaseRespVo.fail("登陆失败，请检查账号和密码");
        }
        String id = (String) subject.getSession().getId();
        return BaseRespVo.ok(id);
    }

    @RequestMapping("logout")
    public BaseRespVo logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return BaseRespVo.ok();
    }

    @RequestMapping("info")
    public BaseRespVo info(String token) {
        Subject subject = SecurityUtils.getSubject();
        String username = (String) subject.getPrincipals().getPrimaryPrincipal();
        AdminExample adminExample = new AdminExample();
        adminExample.createCriteria().andUsernameEqualTo(username).andDeletedEqualTo(false);
        List<Admin> admins = adminMapper.selectByExample(adminExample);
        Integer[] roleIds = admins.get(0).getRoleIds();
        Set<String> permissionSet = new HashSet<String>();
        List<String> roles = new ArrayList<>();
        for (Integer roleId : roleIds) {
            List<String> permissionList = permissionMapper.getPermissionsByRoleId(roleId);
            permissionSet.addAll(permissionList);
            RoleExample roleExample = new RoleExample();
            roleExample.createCriteria().andIdEqualTo(roleId).andDeletedEqualTo(false);
            List<Role> rolesList = roleMapper.selectByExample(roleExample);
            roles.add(rolesList.get(0).getName());
        }
        List<String> permissions = new ArrayList<>(permissionSet);
        return BaseRespVo.ok(new DataBean(roles, username, permissions, admins.get(0).getAvatar()));
//        DataBean dataBean = new DataBean();
//        dataBean.setAvatar("http://localhost:8083/images.png");
//        dataBean.setName("admin");
//        ArrayList<String> perms = new ArrayList<>();
//        perms.add("*");
//        dataBean.setPerms(perms);
//        ArrayList<String> roles = new ArrayList<>();
//        roles.add("超级管理员");
//        dataBean.setRoles(roles);

    }

}
