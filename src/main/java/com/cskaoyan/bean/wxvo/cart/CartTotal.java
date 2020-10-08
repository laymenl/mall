package com.cskaoyan.bean.wxvo.cart;

public class CartTotal {

    private int goodsCount;
    private int checkedGoodsCount;
    private double goodsAmount;
    private double checkedGoodsAmount;

    public int getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(int goodsCount) {
        this.goodsCount = goodsCount;
    }

    public int getCheckedGoodsCount() {
        return checkedGoodsCount;
    }

    public void setCheckedGoodsCount(int checkedGoodsCount) {
        this.checkedGoodsCount = checkedGoodsCount;
    }

    public double getGoodsAmount() {
        return goodsAmount;
    }

    public void setGoodsAmount(double goodsAmount) {
        this.goodsAmount = goodsAmount;
    }

    public double getCheckedGoodsAmount() {
        return checkedGoodsAmount;
    }

    public void setCheckedGoodsAmount(double checkedGoodsAmount) {
        this.checkedGoodsAmount = checkedGoodsAmount;
    }
}
