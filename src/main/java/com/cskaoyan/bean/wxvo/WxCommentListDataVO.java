package com.cskaoyan.bean.wxvo;

import com.cskaoyan.bean.User;
import lombok.Data;

import java.util.List;

@Data
public class WxCommentListDataVO {

    private User userInfo;
    private String addTime;
    private String[] picList;
    private String content;

}