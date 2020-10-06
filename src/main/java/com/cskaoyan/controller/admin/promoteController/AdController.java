package com.cskaoyan.controller.admin.promoteController;

import com.cskaoyan.promoteModule.adManage.bean.Ad;
import com.cskaoyan.promoteModule.adManage.bean.BaseRespVo;
import com.cskaoyan.promoteModule.adManage.bean.ListBean;
import com.cskaoyan.promoteModule.adManage.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin/ad")
public class AdController {

    @Autowired
    AdService adService;

    /*
        参数 page=1&limit=20&sort=add_time&order=desc
    * */
    @RequestMapping("list")
    public BaseRespVo list(Integer page, Integer limit, String sort, String order) {
        ListBean listBean = adService.queryAdListBean(page, limit, sort, order);
        return BaseRespVo.ok(listBean);
    }

    @PostMapping("create")
    public BaseRespVo create(@RequestBody Ad ad) {

        Ad adInfo = adService.create(ad);
        return BaseRespVo.ok(adInfo);
    }

    @RequestMapping("update")
    public BaseRespVo update(@RequestBody Ad ad){
        Ad adInfo = adService.update(ad);
        return BaseRespVo.ok(adInfo);
    }

    @RequestMapping("delete")
    public BaseRespVo delete(@RequestBody Ad ad){
        int status = adService.delete(ad);
        return status == 1? BaseRespVo.ok(): BaseRespVo.fail("delete error");
    }
}
