package com.cskaoyan.controller.wx.wxFootprintController;

import com.cskaoyan.promoteModule.couponManage.bean.BaseRespVo;
import com.cskaoyan.wx_feedBack_footPrint_coupon_pic.footPrintManage.bean.ListBean;
import com.cskaoyan.wx_feedBack_footPrint_coupon_pic.footPrintManage.bean.WxFootprintBo;
import com.cskaoyan.wx_feedBack_footPrint_coupon_pic.footPrintManage.service.WxFootPrintService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("wx/footprint")
public class WxFootPrintController {


    @Resource
    WxFootPrintService wxFootPrintService;

    //page=1&size=10
    @RequestMapping("list")
    public BaseRespVo list(Integer page, Integer size) {
        ListBean listBean = wxFootPrintService.list(page, size);
        return BaseRespVo.ok(listBean);
    }

    //id: 279
    @RequestMapping("delete")
    public BaseRespVo delete(WxFootprintBo wxFootprintBo) {
        int deleteStatus = wxFootPrintService.delete(wxFootprintBo.getId());
        return deleteStatus == 1 ? BaseRespVo.ok() : BaseRespVo.fail("submit error");
    }
}
