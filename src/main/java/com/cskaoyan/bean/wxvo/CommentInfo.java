package com.cskaoyan.bean.wxvo;

import lombok.Data;

import java.util.List;

@Data
public class CommentInfo {

    private String addTime;
    private List<String> picList;
    private String nickname;
    private int id;
    private String avatar;
    private String content;

}