package com.cskaoyan.service;

import com.cskaoyan.bean.GoodsPart.Comment;
import com.cskaoyan.bean.GoodsPart.CommentExample;
import com.cskaoyan.bean.ListBean;
import com.cskaoyan.mapper.CommentMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    CommentMapper commentMapper;

    @Override
    public ListBean queryCommentListBean(Integer page, Integer limit, String sort, String order, Integer userId, Integer valueId) {
        PageHelper.startPage(page, limit);
        CommentExample commentExample = new CommentExample();
        commentExample.setOrderByClause(sort + " " + order);
        CommentExample.Criteria criteria = commentExample.createCriteria();
        if(userId != null){
            criteria.andUserIdEqualTo(userId);
        }
        if(valueId != null){
            criteria.andValueIdEqualTo(valueId);
        }
        criteria.andDeletedEqualTo(false);
        List<Comment> comments = commentMapper.selectByExample(commentExample);
        PageInfo pageInfo = new PageInfo(comments);
        long total = pageInfo.getTotal();
        ListBean listBean = new ListBean(comments, total);
        return listBean;
    }

    @Override
    public void delete(Integer id) throws RuntimeException{
        try{
            commentMapper.setDeletedTrue(id);
        }catch (Exception exception){
            throw new RuntimeException();
        }
    }

}
