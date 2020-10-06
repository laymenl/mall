package com.cskaoyan.bean.wxvo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginVO {

    private UserInfoVO userInfo;
    private String tokenExpire;
    private String token;

}
