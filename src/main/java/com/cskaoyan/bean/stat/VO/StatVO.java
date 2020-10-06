package com.cskaoyan.bean.stat.VO;

import lombok.Data;

import java.util.List;

@Data
public class StatVO<T> {
    private List<String> columns;
    private List<T> rows;
}
