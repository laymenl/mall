package com.cskaoyan.bean.wxvo.cart;

import com.cskaoyan.bean.UserAddress;
import lombok.Data;

import java.util.List;

@Data
public class CheckoutVO {
    private int grouponPrice;
    private int grouponRulesId;
    private UserAddress checkedAddress;
    private double actualPrice;
    private double orderTotalPrice;
    private double couponPrice;
    private int availableCouponLength;
    private int couponId;
    private int freightPrice;
    private double goodsTotalPrice;
    private int addressId;
    private List checkedGoodsList;
}
