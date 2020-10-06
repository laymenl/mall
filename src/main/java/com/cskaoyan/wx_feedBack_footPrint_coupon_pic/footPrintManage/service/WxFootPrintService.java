package com.cskaoyan.wx_feedBack_footPrint_coupon_pic.footPrintManage.service;

import com.cskaoyan.bean.feedback.UserFeedback;
import com.cskaoyan.wx_feedBack_footPrint_coupon_pic.footPrintManage.bean.ListBean;

public interface WxFootPrintService {

    ListBean list(Integer page, Integer size);

    int delete(Integer id);
}
