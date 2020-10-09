package com.cskaoyan.controller.wx;

import com.cskaoyan.bean.BaseRespVo;
import com.cskaoyan.bean.wxvo.CommentCountVO;
import com.cskaoyan.bean.wxvo.WxCommentListVO;
import com.cskaoyan.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wx/comment")
public class WxCommentController {

    @Autowired
    CommentService commentService;

    @RequestMapping("count")
    public BaseRespVo count(int valueId, int type){
       CommentCountVO commentCountVO = commentService.count(valueId, type);
       return BaseRespVo.ok(commentCountVO);
    }

    @RequestMapping("list")
    public BaseRespVo list(Integer valueId, Byte type, Integer size, Integer page, Byte showType){
        //todo
        WxCommentListVO wxCommentListVO = commentService.list(valueId, type, size, page, showType);
        return BaseRespVo.ok(wxCommentListVO);
    }
}
