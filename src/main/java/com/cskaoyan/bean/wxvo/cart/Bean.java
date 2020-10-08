package com.cskaoyan.bean.wxvo.cart;

import java.util.List;

public class Bean {
    public static class DataBean {
        private int grouponPrice;
        private int grouponRulesId;
        private CheckedAddressBean checkedAddress;
        private double actualPrice;
        private double orderTotalPrice;
        private double couponPrice;
        private int availableCouponLength;
        private int couponId;
        private int freightPrice;
        private double goodsTotalPrice;
        private int addressId;
        private List<CheckedGoodsListBean> checkedGoodsList;

        public int getGrouponPrice() {
            return grouponPrice;
        }

        public void setGrouponPrice(int grouponPrice) {
            this.grouponPrice = grouponPrice;
        }

        public int getGrouponRulesId() {
            return grouponRulesId;
        }

        public void setGrouponRulesId(int grouponRulesId) {
            this.grouponRulesId = grouponRulesId;
        }

        public CheckedAddressBean getCheckedAddress() {
            return checkedAddress;
        }

        public void setCheckedAddress(CheckedAddressBean checkedAddress) {
            this.checkedAddress = checkedAddress;
        }

        public double getActualPrice() {
            return actualPrice;
        }

        public void setActualPrice(double actualPrice) {
            this.actualPrice = actualPrice;
        }

        public double getOrderTotalPrice() {
            return orderTotalPrice;
        }

        public void setOrderTotalPrice(double orderTotalPrice) {
            this.orderTotalPrice = orderTotalPrice;
        }

        public double getCouponPrice() {
            return couponPrice;
        }

        public void setCouponPrice(double couponPrice) {
            this.couponPrice = couponPrice;
        }

        public int getAvailableCouponLength() {
            return availableCouponLength;
        }

        public void setAvailableCouponLength(int availableCouponLength) {
            this.availableCouponLength = availableCouponLength;
        }

        public int getCouponId() {
            return couponId;
        }

        public void setCouponId(int couponId) {
            this.couponId = couponId;
        }

        public int getFreightPrice() {
            return freightPrice;
        }

        public void setFreightPrice(int freightPrice) {
            this.freightPrice = freightPrice;
        }

        public double getGoodsTotalPrice() {
            return goodsTotalPrice;
        }

        public void setGoodsTotalPrice(double goodsTotalPrice) {
            this.goodsTotalPrice = goodsTotalPrice;
        }

        public int getAddressId() {
            return addressId;
        }

        public void setAddressId(int addressId) {
            this.addressId = addressId;
        }

        public List<CheckedGoodsListBean> getCheckedGoodsList() {
            return checkedGoodsList;
        }

        public void setCheckedGoodsList(List<CheckedGoodsListBean> checkedGoodsList) {
            this.checkedGoodsList = checkedGoodsList;
        }

        public static class CheckedAddressBean {
            /**
             * id : 4
             * name : 张松
             * userId : 1
             * provinceId : 12
             * cityId : 130
             * areaId : 1289
             * address : 碧桂园
             * mobile : 18566549962
             * isDefault : false
             * addTime : 2020-04-27 20:57:32
             * updateTime : 2020-10-07 19:57:43
             * deleted : true
             */

            private int id;
            private String name;
            private int userId;
            private int provinceId;
            private int cityId;
            private int areaId;
            private String address;
            private String mobile;
            private boolean isDefault;
            private String addTime;
            private String updateTime;
            private boolean deleted;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public int getProvinceId() {
                return provinceId;
            }

            public void setProvinceId(int provinceId) {
                this.provinceId = provinceId;
            }

            public int getCityId() {
                return cityId;
            }

            public void setCityId(int cityId) {
                this.cityId = cityId;
            }

            public int getAreaId() {
                return areaId;
            }

            public void setAreaId(int areaId) {
                this.areaId = areaId;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public boolean isIsDefault() {
                return isDefault;
            }

            public void setIsDefault(boolean isDefault) {
                this.isDefault = isDefault;
            }

            public String getAddTime() {
                return addTime;
            }

            public void setAddTime(String addTime) {
                this.addTime = addTime;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }

            public boolean isDeleted() {
                return deleted;
            }

            public void setDeleted(boolean deleted) {
                this.deleted = deleted;
            }
        }

        public static class CheckedGoodsListBean {
            /**
             * id : 298
             * userId : 1
             * goodsId : 1109008
             * goodsSn : 1109008
             * goodsName : 云端沙发组合
             * productId : 140
             * price : 3999.0
             * number : 1
             * specifications : ["标准"]
             * checked : true
             * picUrl : http://yanxuan.nosdn.127.net/c5be2604c0e4186a4e7079feeb742cee.png
             * addTime : 2020-10-07 20:43:24
             * updateTime : 2020-10-07 22:57:45
             * deleted : false
             */

            private int id;
            private int userId;
            private int goodsId;
            private String goodsSn;
            private String goodsName;
            private int productId;
            private double price;
            private int number;
            private boolean checked;
            private String picUrl;
            private String addTime;
            private String updateTime;
            private boolean deleted;
            private List<String> specifications;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public int getGoodsId() {
                return goodsId;
            }

            public void setGoodsId(int goodsId) {
                this.goodsId = goodsId;
            }

            public String getGoodsSn() {
                return goodsSn;
            }

            public void setGoodsSn(String goodsSn) {
                this.goodsSn = goodsSn;
            }

            public String getGoodsName() {
                return goodsName;
            }

            public void setGoodsName(String goodsName) {
                this.goodsName = goodsName;
            }

            public int getProductId() {
                return productId;
            }

            public void setProductId(int productId) {
                this.productId = productId;
            }

            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public int getNumber() {
                return number;
            }

            public void setNumber(int number) {
                this.number = number;
            }

            public boolean isChecked() {
                return checked;
            }

            public void setChecked(boolean checked) {
                this.checked = checked;
            }

            public String getPicUrl() {
                return picUrl;
            }

            public void setPicUrl(String picUrl) {
                this.picUrl = picUrl;
            }

            public String getAddTime() {
                return addTime;
            }

            public void setAddTime(String addTime) {
                this.addTime = addTime;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }

            public boolean isDeleted() {
                return deleted;
            }

            public void setDeleted(boolean deleted) {
                this.deleted = deleted;
            }

            public List<String> getSpecifications() {
                return specifications;
            }

            public void setSpecifications(List<String> specifications) {
                this.specifications = specifications;
            }
        }
    }
}
