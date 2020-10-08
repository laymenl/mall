package com.cskaoyan.bean.wxvo;
import com.cskaoyan.bean.wxvo.WxOrderListDataGoodsList;
import com.cskaoyan.bean.wxvo.WxOrderListDataHandleOption;
import lombok.Data;

import java.util.List;

@Data
public class WxOrderListData {
    private String orderStatusText;
    private Boolean isGroupin;
    private String orderSn;
    private Integer actualPrice;
    private List<WxOrderListDataGoodsList> goodsList;
    private Integer id;
    private WxOrderListDataHandleOption handleOption;
}