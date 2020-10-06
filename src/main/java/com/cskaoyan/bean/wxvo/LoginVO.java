package com.cskaoyan.bean.wxvo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginVO {

    private UserInfoVO userInfo;
    private Date tokenExpire;
    private String token;

}
