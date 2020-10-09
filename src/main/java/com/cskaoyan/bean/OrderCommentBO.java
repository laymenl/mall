package com.cskaoyan.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderCommentBO {
    Integer orderGoodsId;
    String content;
    Integer star;
    Boolean hasPicture;
    String[] picUrls;
}
