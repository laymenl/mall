package com.cskaoyan.controller.wx.wxFeedbackController;

import com.cskaoyan.bean.feedback.UserFeedback;
import com.cskaoyan.promoteModule.couponManage.bean.BaseRespVo;
import com.cskaoyan.wx_feedBack_footPrint_coupon_pic.feedBackManage.service.WxFeedBackService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("wx/feedback")
public class WxFeedBackController {


    @Resource
    WxFeedBackService wxFeedBackService;

    @RequestMapping("submit")
    public BaseRespVo submit(@RequestBody UserFeedback userFeedback) {
        int submitStatus = wxFeedBackService.submit(userFeedback);
        return submitStatus == 1 ? BaseRespVo.ok() : BaseRespVo.fail("submit error");
    }
}
