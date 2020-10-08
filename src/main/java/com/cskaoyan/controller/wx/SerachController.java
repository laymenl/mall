package com.cskaoyan.controller.wx;

import com.cskaoyan.bean.BaseRespVo;
import com.cskaoyan.bean.wxvo.SerachIndexVO;
import com.cskaoyan.service.shopService.KeywordService;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/wx/search")
public class SerachController {

    @Autowired
    KeywordService keywordService;


    @RequestMapping("index")
    public BaseRespVo index(){
        SerachIndexVO serachIndexVO = keywordService.index();
        return BaseRespVo.ok(serachIndexVO);
    }

    @RequestMapping("helper")
    public BaseRespVo helper(String keyword){
        List<String> helperList = keywordService.helper(keyword);
        return BaseRespVo.ok(helperList);
    }

    @RequestMapping("clearhistory")
    public BaseRespVo clearHistory(){
        try {
            keywordService.clearHistory();
        } catch (Exception exception) {
            exception.printStackTrace();
            return BaseRespVo.fail("清除失败");
        }
        return BaseRespVo.ok();
    }
}
