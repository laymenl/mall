package com.cskaoyan.service;

import com.cskaoyan.bean.GoodsPart.Comment;
import com.cskaoyan.bean.GoodsPart.CommentExample;
import com.cskaoyan.bean.ListBean;
import com.cskaoyan.bean.wxvo.CommentCountVO;
import com.cskaoyan.bean.wxvo.WxCommentListVO;
import com.cskaoyan.mapper.CommentMapper;
import com.github.pagehelper.Page;
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

    @Override
    public CommentCountVO count(int valueId, int type) {
        CommentExample commentExample = new CommentExample();
        CommentExample.Criteria criteria = commentExample.createCriteria();
        criteria.andValueIdEqualTo(valueId).andDeletedEqualTo(false).andTypeEqualTo((byte)type);
        int allCount = (int) commentMapper.countByExample(commentExample);
        criteria.andHasPictureEqualTo(true);
        int hasPicCount = (int) commentMapper.countByExample(commentExample);
        return new CommentCountVO(hasPicCount, allCount);
    }

    @Override
    public WxCommentListVO list(Integer valueId, Byte type, Integer size, Integer page, Byte showType) {

        //todo
        CommentExample commentExample = new CommentExample();
        CommentExample.Criteria criteria = commentExample.createCriteria();
        criteria.andTypeEqualTo(type).andDeletedEqualTo(false).andValueIdEqualTo(valueId);
        if(showType == 1){
            criteria.andHasPictureEqualTo(true);
        }
        PageHelper.startPage(page, size);

        return null;
    }

}
