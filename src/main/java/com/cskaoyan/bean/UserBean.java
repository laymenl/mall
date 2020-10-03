package com.cskaoyan.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class UserBean {

            /**
             * id : 1
             * username : test1
             * password : $2a$10$3joHPif3l/wsyKqxZA8aieZGQCWFcibfEtSJhAFLGovRPdtruDOuO
             * gender : 0
             * birthday : 2020-04-29
             * lastLoginTime : 2020-04-27 20:15:47
             * lastLoginIp :
             * userLevel : 0
             * nickname : 测试用户
             * mobile : 13554556544
             * avatar : https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif?imageView2/1/w/80/h/80
             * weixinOpenid :
             * status : 0
             * deleted : false
             */
     private int id;
    private String username;
    private String password;
    private int gender;
    private String birthday;
    private String lastLoginTime;
    private String lastLoginIp;
    private int userLevel;
    private String nickname;
    private String mobile;
    private String avatar;
    private String weixinOpenid;
    private int status;
    private boolean deleted;
        }


