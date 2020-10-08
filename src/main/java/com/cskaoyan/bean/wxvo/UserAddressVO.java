package com.cskaoyan.bean.wxvo;

import lombok.Data;

@Data
public class UserAddressVO {

        /**
         * isDefault : false
         * detailedAddress : 新疆维吾尔自治区阿勒泰地区青河县 哈哈哈哈哈哈
         * name : 马家骏
         * mobile : 15978567856
         * id : 10
         */

        private boolean isDefault;
        private String detailedAddress;
        private String name;
        private String mobile;
        private int id;

}
