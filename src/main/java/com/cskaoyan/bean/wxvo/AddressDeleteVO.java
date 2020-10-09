package com.cskaoyan.bean.wxvo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AddressDeleteVO {

    /**
     * errno : 0
     * errmsg : 成功
     */

    private int errno = 0;
    private String errmsg = "成功";


}
