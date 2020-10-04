package com.cskaoyan.promoteModule.grouponManage.bean.listRecord;

import com.cskaoyan.bean.GoodsPart.Goods;
import com.cskaoyan.promoteModule.grouponManage.bean.GrouponRules;
import lombok.Data;

@Data
public class ListRecordVo {
    private Groupon groupon;
    private GrouponRules rules;
    private Goods goods;
    private String[] subGroupons;
}
