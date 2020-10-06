package com.cskaoyan.controller.admin.shopController;

import com.cskaoyan.bean.BaseRespVo;
import com.cskaoyan.bean.ListBean;
import com.cskaoyan.bean.shop.keyword.Keyword;
import com.cskaoyan.service.shopService.KeywordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin/keyword")
public class KeywordController {

    @Autowired
    KeywordService keywordService;

    @RequestMapping("list")
    public BaseRespVo list(String keyword,String url,Integer page,Integer limit,String sort,String order){
        ListBean listBean = keywordService.list(keyword,url,page,limit,sort,order);
        return BaseRespVo.ok(listBean);
    }

    @RequestMapping("create")
    public BaseRespVo create(@RequestBody Keyword keyword){
        Keyword keywordResult = keywordService.create(keyword);
        return BaseRespVo.ok(keywordResult);
    }

    @RequestMapping("update")
    public BaseRespVo update(@RequestBody Keyword keyword){
        Keyword keywordResult = keywordService.update(keyword);
        return BaseRespVo.ok(keywordResult);
    }

    @RequestMapping("delete")
    public BaseRespVo delete(@RequestBody Keyword keyword){
        keywordService.delete(keyword);
        return BaseRespVo.ok();
    }
}
