package com.cskaoyan.mapper;


import java.util.List;

import com.cskaoyan.bean.GoodsPart.Comment;
import com.cskaoyan.bean.GoodsPart.CommentExample;
import com.cskaoyan.bean.wxvo.WxCommentListDataVO;
import org.apache.ibatis.annotations.Param;

public interface CommentMapper {
    long countByExample(CommentExample example);

    int deleteByExample(CommentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Comment record);

    int insertSelective(Comment record);

    List<Comment> selectByExample(CommentExample example);

    Comment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Comment record, @Param("example") CommentExample example);

    int updateByExample(@Param("record") Comment record, @Param("example") CommentExample example);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

    void setDeletedTrue(Integer id);
    void insertComment(@Param("goodsId")Integer goodsId, @Param("content")String content, @Param("star")Integer star, @Param("hasPicture")Boolean hasPicture, @Param("picUrls")String[] picUrls);

    List<WxCommentListDataVO> selectWxCommentListData(@Param("valueId") Integer valueId, @Param("size") Integer size, @Param("type") Byte type, @Param("offset") Integer offset);
}