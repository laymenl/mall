package com.cskaoyan.mapper;

import com.cskaoyan.bean.history.UserSearchHistory;
import com.cskaoyan.bean.history.UserSearchHistoryExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserSearchHistoryMapper {
    long countByExample(UserSearchHistoryExample example);

    int deleteByExample(UserSearchHistoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserSearchHistory record);

    int insertSelective(UserSearchHistory record);

    List<UserSearchHistory> selectByExample(UserSearchHistoryExample example);

    UserSearchHistory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserSearchHistory record, @Param("example") UserSearchHistoryExample example);

    int updateByExample(@Param("record") UserSearchHistory record, @Param("example") UserSearchHistoryExample example);

    int updateByPrimaryKeySelective(UserSearchHistory record);

    int updateByPrimaryKey(UserSearchHistory record);
}