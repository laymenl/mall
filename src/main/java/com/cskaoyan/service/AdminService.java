package com.cskaoyan.service;

import com.cskaoyan.bean.SystemPart.Admin;
import com.cskaoyan.bean.ListBean;


public interface AdminService {
    ListBean queryAdminListBean(String username, Integer page, Integer limit, String sort, String order);
    void createAdmin(Admin admin);
    void updateAdmin(Admin admin);
    void deleteAdmin(Admin admin);
}
