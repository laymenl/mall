package com.cskaoyan.bean.wxvo;

import lombok.Data;

import java.util.List;

@Data
public class CommentEntity {

    private List<CommentInfo> data;
    private int count;


}