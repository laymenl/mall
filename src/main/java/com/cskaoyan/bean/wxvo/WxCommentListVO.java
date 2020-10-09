package com.cskaoyan.bean.wxvo;

import lombok.Data;

import java.util.List;

@Data
public class WxCommentListVO {

    private List<WxCommentListDataVO> data;

    private int count;

    private int currentPage;

}
