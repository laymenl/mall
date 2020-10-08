package com.cskaoyan.bean.wxvo;

import lombok.Data;

import java.util.List;

@Data
public class WxOrderListVO {
    private List<WxOrderListData> data;
    private Integer count;
    private Integer totalPages;
}