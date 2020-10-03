package com.cskaoyan.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class AddressBean {
            /**
             * area : 洪山区
             * isDefault : true
             * areaId : 1881
             * address : 软件新城2期
             * province : 湖北省
             * city : 武汉市
             * name : 李艮隶
             * mobile : 13835136642
             * id : 6
             * cityId : 201
             * userId : 2
             * provinceId : 17
             */
            @JsonProperty("area")
            private String area;
            @JsonProperty("isDefault")
            private Boolean isDefault;
            @JsonProperty("areaId")
            private Integer areaId;
            @JsonProperty("address")
            private String address;
            @JsonProperty("province")
            private String province;
            @JsonProperty("city")
            private String city;
            @JsonProperty("name")
            private String name;
            @JsonProperty("mobile")
            private String mobile;
            @JsonProperty("id")
            private Integer id;
            @JsonProperty("cityId")
            private Integer cityId;
            @JsonProperty("userId")
            private Integer userId;
            @JsonProperty("provinceId")
            private Integer provinceId;
}
