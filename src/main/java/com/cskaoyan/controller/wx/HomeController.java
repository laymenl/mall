package com.cskaoyan.controller.wx;

import com.cskaoyan.bean.BaseRespVo;
import com.cskaoyan.bean.wxvo.IndexVO;
import com.cskaoyan.service.wx.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wx/home")
public class HomeController {

    @Autowired
    IndexService indexService;

    @RequestMapping("index")
    public BaseRespVo index(){
        IndexVO indexVO = indexService.index();
        return BaseRespVo.ok(indexVO);
    }

}
