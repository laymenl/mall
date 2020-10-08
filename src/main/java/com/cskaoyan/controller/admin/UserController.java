package com.cskaoyan.controller.admin;

import com.cskaoyan.bean.AddressListBean;
import com.cskaoyan.bean.BaseRespVo;
import com.cskaoyan.bean.ListBean;
import com.cskaoyan.bean.collect.CollectListBean;
import com.cskaoyan.bean.feedback.FeedBackListBean;
import com.cskaoyan.bean.footprint.FootPrintListBean;
import com.cskaoyan.bean.history.HistoryListBean;
import com.cskaoyan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/user/list")
    public BaseRespVo list(String username, String mobile,Integer page,Integer limit,String sort,String order){
        ListBean listBean = userService.queryUserListBean(username, mobile,page,limit,sort,order);
        return BaseRespVo.ok(listBean);
    }
    @RequestMapping("/address/list")
    public BaseRespVo address(String userId, String name, Integer page, Integer limit, String sort, String order){
        AddressListBean addressListBean = userService.queryUserAddressListBean(userId,  name, page, limit, sort, order);
        return BaseRespVo.ok(addressListBean);
    }
    @RequestMapping("/collect/list")
    public BaseRespVo collect(Integer userId, Integer valueId,Integer page,Integer limit,String sort,String order){
        CollectListBean collectListBean = userService.queryUserCollectListBean(userId, valueId, page, limit, sort, order);
        return BaseRespVo.ok(collectListBean);
    }
    @RequestMapping("/footprint/list")
    public BaseRespVo footprint(Integer userId, Integer goodId,Integer page,Integer limit,String sort,String order){
        FootPrintListBean footPrintListBean = userService.queryUserFootPrintListBean(userId, goodId, page, limit, sort, order);
        return BaseRespVo.ok(footPrintListBean);
    }
    @RequestMapping("/history/list")
    public BaseRespVo history(Integer userId, String keyword,Integer page,Integer limit,String sort,String order){
        HistoryListBean historyListBean = userService.queryUserSearchHistoryListBean(userId, keyword, page, limit, sort, order);
        return BaseRespVo.ok(historyListBean);
    }
    @RequestMapping("/feedback/list")
    public BaseRespVo feedback(String username, Integer id,Integer page,Integer limit,String sort,String order){
        FeedBackListBean feedBackListBean = userService.queryUserFeedBackListBean(username, id, page, limit, sort, order);
        return BaseRespVo.ok(feedBackListBean);
    }
}
