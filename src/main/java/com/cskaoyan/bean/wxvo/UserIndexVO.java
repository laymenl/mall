package com.cskaoyan.bean.wxvo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class UserIndexVO {

    /**
     * order : {"unrecv":0,"uncomment":3,"unpaid":0,"unship":0}
     */
    private OrderEntity order;

    public UserIndexVO(int unrecv, int uncomment, int upaid, int unship) {
        order = new OrderEntity(unrecv, uncomment, upaid, unship);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class OrderEntity {
        /**
         * unrecv : 0
         * uncomment : 3
         * unpaid : 0
         * unship : 0
         */
        private int unrecv;
        private int uncomment;
        private int unpaid;
        private int unship;
    }
}
