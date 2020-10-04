package com.cskaoyan.controller;

import com.cskaoyan.bean.BaseRespVo;
import com.cskaoyan.bean.GoodsPart.Comment;
import com.cskaoyan.bean.ListBean;
import com.cskaoyan.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


@RestController
@RequestMapping("admin/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    //page=1&limit=20&sort=add_time&order=desc
    @RequestMapping("list")
    public BaseRespVo list(Integer page, Integer limit, String sort, String order, Integer userId, Integer valueId){
        ListBean listBean = commentService.queryCommentListBean(page, limit, sort, order, userId, valueId);
        return BaseRespVo.ok(listBean);
    }

    @RequestMapping("delete")
    public BaseRespVo delete(@RequestBody Comment comment){
        try{
            commentService.delete(comment.getId());
        }catch (Exception exception){
            return BaseRespVo.fail("删除出错");
        }
        return BaseRespVo.ok();
    }
}
