package com.cskaoyan.controller.admin.shopController;

import com.cskaoyan.bean.BaseRespVo;
import com.cskaoyan.bean.ListBean;
import com.cskaoyan.bean.shop.issue.Issue;
import com.cskaoyan.service.shopService.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin/issue")
public class IssueController {

    @Autowired
    IssueService issueService;

    @RequestMapping("list")
    public BaseRespVo list(String question,Integer page, Integer limit, String sort, String order){
        ListBean listBean = issueService.list(question,page,limit,sort,order);
        return BaseRespVo.ok(listBean);
    }

    @RequestMapping("create")
    public BaseRespVo create(@RequestBody Issue issue){
        Issue issueResult = issueService.create(issue);
        return BaseRespVo.ok(issueResult);
    }

    @RequestMapping("update")
    public BaseRespVo update(@RequestBody Issue issue){
        Issue issueResult = issueService.update(issue);
        return BaseRespVo.ok(issueResult);
    }
    @RequestMapping("delete")
    public BaseRespVo delete(@RequestBody Issue issue){
        issueService.delete(issue);
        return BaseRespVo.ok();
    }
}
