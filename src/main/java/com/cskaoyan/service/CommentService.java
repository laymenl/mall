package com.cskaoyan.service;

import com.cskaoyan.bean.ListBean;

public interface CommentService {
    ListBean queryCommentListBean(Integer page, Integer limit, String sort, String order, Integer userId, Integer valueId);

    void delete(Integer id);
}
