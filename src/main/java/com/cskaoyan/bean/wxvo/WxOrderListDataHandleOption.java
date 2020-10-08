package com.cskaoyan.bean.wxvo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WxOrderListDataHandleOption {
    private Boolean cancel;
    private Boolean delete;
    private Boolean pay;
    private Boolean comment;
    private Boolean confirm;
    private Boolean refund;
    private Boolean rebuy;
}