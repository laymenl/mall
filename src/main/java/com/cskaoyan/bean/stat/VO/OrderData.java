package com.cskaoyan.bean.stat.VO;

import lombok.Data;

import java.util.List;

@Data
public class OrderData {
        private double amount;
        private int orders;
        private int customers;
        private String day;
        private double pcr;

}
