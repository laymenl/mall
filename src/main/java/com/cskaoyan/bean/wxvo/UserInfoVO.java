package com.cskaoyan.bean.wxvo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoVO {
    /**
     * avatarUrl : https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif?imageView2/1/w/80/h/80
     * nickName : test1
     */
    private String avatarUrl;
    private String nickName;

}