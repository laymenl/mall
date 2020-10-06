package com.cskaoyan.shiro;



import com.cskaoyan.bean.SystemPart.Admin;
import com.cskaoyan.bean.SystemPart.AdminExample;
import com.cskaoyan.mapper.AdminMapper;
import com.cskaoyan.mapper.PermissionMapper;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class AdminRealm extends AuthorizingRealm {

    @Autowired
    AdminMapper adminMapper;

    @Autowired
    PermissionMapper permissionMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) principalCollection.getPrimaryPrincipal();
        AdminExample adminExample = new AdminExample();
        adminExample.createCriteria().andUsernameEqualTo(username);
        List<Admin> admins = adminMapper.selectByExample(adminExample);
        Integer[] roleIds = admins.get(0).getRoleIds();
        Set<String> permissionSet = new HashSet<String>();
        for (Integer roleId : roleIds) {
            List<String> permissionList = permissionMapper.getPermissionsByRoleId(roleId);
            permissionSet.addAll(permissionList);
        }
        List<String> permissions = new ArrayList<>(permissionSet);
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.addStringPermissions(permissions);
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        String password;
        //todo 可以给加密
        if(username.equals("admin123") || username.equals("mall123") || username.equals("promotion123")){
            password = username;
        }
        else {
            AdminExample adminExample = new AdminExample();
            adminExample.createCriteria().andUsernameEqualTo(username);
            List<Admin> admins = adminMapper.selectByExample(adminExample);
            password = admins.size() > 0 ? admins.get(0).getPassword():null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username, password, this.getName());
        return authenticationInfo;
    }
}
