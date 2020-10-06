package com.cskaoyan.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DashBoardVO {
    private int goodsTotal;
    private int userTotal;
    private int productTotal;
    private int orderTotal;
}
