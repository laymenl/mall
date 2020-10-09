package com.cskaoyan.bean.wxvo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WxCommentListVO {

    private List<WxCommentListDataVO> data;

    private int count;

    private int currentPage;

}
