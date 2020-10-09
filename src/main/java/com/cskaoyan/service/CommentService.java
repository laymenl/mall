package com.cskaoyan.service;

import com.cskaoyan.bean.ListBean;
import com.cskaoyan.bean.wxvo.CommentCountVO;
import com.cskaoyan.bean.wxvo.WxCommentListVO;

public interface CommentService {
    ListBean queryCommentListBean(Integer page, Integer limit, String sort, String order, Integer userId, Integer valueId);

    void delete(Integer id);

    CommentCountVO count(int id, int valueId);

    WxCommentListVO list(Integer valueId, Byte type, Integer size, Integer page, Byte showType);
}
