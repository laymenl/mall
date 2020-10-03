package com.cskaoyan.mapper;

import com.cskaoyan.bean.feedback.UserFeedback;
import com.cskaoyan.bean.feedback.UserFeedbackExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserFeedbackMapper {
    long countByExample(UserFeedbackExample example);

    int deleteByExample(UserFeedbackExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserFeedback record);

    int insertSelective(UserFeedback record);

    List<UserFeedback> selectByExample(UserFeedbackExample example);

    UserFeedback selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserFeedback record, @Param("example") UserFeedbackExample example);

    int updateByExample(@Param("record") UserFeedback record, @Param("example") UserFeedbackExample example);

    int updateByPrimaryKeySelective(UserFeedback record);

    int updateByPrimaryKey(UserFeedback record);
}