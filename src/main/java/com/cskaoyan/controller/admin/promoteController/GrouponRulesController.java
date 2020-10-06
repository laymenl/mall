package com.cskaoyan.controller.admin.promoteController;


import com.cskaoyan.promoteModule.grouponManage.bean.BaseRespVo;
import com.cskaoyan.promoteModule.grouponManage.bean.GrouponRules;
import com.cskaoyan.promoteModule.grouponManage.bean.ListBean;
import com.cskaoyan.promoteModule.grouponManage.service.GrouponRulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin/groupon")
public class GrouponRulesController {

    @Autowired
    GrouponRulesService grouponRulesService;

    /*
        参数 page=1&limit=20&sort=add_time&order=desc
    * */
    @RequestMapping("list")
    public BaseRespVo list(Integer page, Integer limit, String sort, String order) {
        ListBean listBean = grouponRulesService.queryGrouponRulesListBean(page, limit, sort, order);
        return BaseRespVo.ok(listBean);
    }

    @RequestMapping("listRecord")
    public BaseRespVo listRecord(Integer page, Integer limit, String sort, String order) {
        ListBean listBean = grouponRulesService.queryRecordListBean(page, limit, sort, order);
        return BaseRespVo.ok(listBean);
    }

    @RequestMapping("create")
    public BaseRespVo create(@RequestBody GrouponRules grouponRules) {
        GrouponRules grouponInfo= grouponRulesService.create(grouponRules);
        return BaseRespVo.ok(grouponInfo);
    }


    @RequestMapping("update")
    public BaseRespVo update(@RequestBody GrouponRules grouponRules){
        GrouponRules grouponInfo = grouponRulesService.update(grouponRules);
        return BaseRespVo.ok(grouponInfo);
    }


    @RequestMapping("delete")
    public BaseRespVo delete(@RequestBody GrouponRules grouponRules){
        int status = grouponRulesService.delete(grouponRules);
        return status == 1? BaseRespVo.ok(): BaseRespVo.fail("delete error");
    }
}

