package com.cskaoyan.bean.history;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSearchHistory {
    private Integer id;

    private Integer userId;

    private String keyword;

    private String from = "wx";

    private Date addTime = new Date();

    private Date updateTime = new Date();

    private Boolean deleted = false;

}