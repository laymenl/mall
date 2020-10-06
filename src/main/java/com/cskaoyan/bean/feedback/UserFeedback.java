package com.cskaoyan.bean.feedback;

import lombok.Data;

import java.util.Date;

@Data
public class UserFeedback {
    private Integer id;

    private Integer userId;

    private String username;

    private String mobile;

    private String feedType;

    private String content;

    private Integer status = 0;

    private Boolean hasPicture;

    private String[] picUrls;

    private Date addTime;

    private Date updateTime;

    private Boolean deleted;

}